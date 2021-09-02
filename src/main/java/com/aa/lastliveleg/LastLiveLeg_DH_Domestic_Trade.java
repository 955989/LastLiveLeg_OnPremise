/**
 * Developed By : sivan kumar
 * Date : 26-Jul-2021
 * The script will create a new Flight, new Sequence and create Last Live Leg sequence.
 *      1. Get a sequence with 2 segments and FA from TestData sheet
        2. Legality check of LLL and FA
        3. remove last leg - HE H6
            HE/seq#/seq date/25/15
            h6/leg to be removed/date/leg base
            hz/leg position
            ET

        4. Create LL sequence with OpsHubservice
            Create sequence with usual way
        5. assign new FA (LH) to new LL Seq
            HU/emp/pos/seq/date/LL

        6. 2G to remove FA from LL Seq
            Remove FA with 2G command
        7. Delete the LL sequence
            HK/seq#/SeqDate/1

Create Sequence and Delete Sequence services hit to OpsHub services in this script
 */
package com.aa.lastliveleg;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.aa.ccsservices.CCS_Contractual_Month;
import com.aa.ccsservices.CCS_getSequenceDetailsByKeysNew;
import com.aa.entities.ResponseEntity;
import com.aa.entities.SequenceDetailsEntity;
import com.aa.entities.ccsResponse.SequenceInfoKeyResponse;
import com.aa.entities.opshubCreateResponse.OpshubCreateResponse;
import com.aa.entities.qlarequest.FlightLegs;
import com.aa.entities.qlarequest.QLARequestPayload;
import com.aa.entities.qlaresponse.QlaResponsePayload;
import com.aa.opshubservices.OPSHUB_Sequence_Assignment;
import com.aa.opshubservices.RevertModificationService;
import com.aa.opshubservices.SequenceCreateService;
import com.aa.opshubservices.SequenceDeleteService;
import com.aa.opshubservices.SequenceModificationService;
import com.aa.qlaservices.CCS_QLA_SequenceDetails_Mapping;
import com.aa.qlaservices.QlaEmpDataFromCCS;
import com.aa.qlaservices.QlaValidation_Legaity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LastLiveLeg_DH_Domestic_Trade {

    @Autowired
    private SequenceModificationService seqmod;

    @Autowired
    private SequenceCreateService seqCre;

    @Autowired
    private OPSHUB_Sequence_Assignment seqAssign;

    @Autowired
    private SequenceDeleteService seqDel;

    @Autowired
    private CCS_getSequenceDetailsByKeysNew ccs;

    @Autowired
    private QlaEmpDataFromCCS map_QLA_EmpData;

//    @Autowired
//    private CCS_QLA_SequenceDetails_Mapping map_QLA_SequenceDetails;

    @Autowired
    private RevertModificationService revseqmod;

    @Autowired
    private CCS_Contractual_Month conMon;

    
    /**
     * @author ugoudar
     * @param sd
     * @return
     * @throws NoSuchFieldException
     * @throws IOException
     * @throws AWTException
     * @throws InterruptedException
     * @throws ParseException
     * @throws org.json.simple.parser.ParseException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws KeyManagementException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws org.apache.tomcat.util.json.ParseException
     */
    @Async("asyncExecutor")
    public CompletableFuture<ResponseEntity> tradeLLL(final SequenceDetailsEntity sd)
            throws NoSuchFieldException, IOException, AWTException,
            InterruptedException, ParseException, org.json.simple.parser.ParseException, ParserConfigurationException,
            SAXException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException,
            KeyStoreException, CertificateException, org.apache.tomcat.util.json.ParseException {

    	
    	//Generate random number for Log file
    	Random ran = new Random();
    	int ranNum = ran.nextInt(100);
    	
        final ResponseEntity response = new ResponseEntity();

        final String dateTimeToReport = new SimpleDateFormat("dd-MMM-yyyy-dd-hh-mm-ss").format(new Date());

        // Create log file
        final String logFileName = System.getProperty("user.dir") + "Log" + " - " + dateTimeToReport+ ranNum + ".log";
        final PrintStream o = new PrintStream(new File(logFileName));
        final PrintStream console = System.out;
        System.setOut(o);

        final QlaValidation_Legaity qvl = new QlaValidation_Legaity();

        System.out.println("Execution started to trade LLL of Sequence " + sd.getSequenceNum() + " of FA1 "
                + sd.getFa1ID() + " to trade Last Live leg by FA2 " + sd.getFa2ID());
                    
        try {

        final String contractualmonth = conMon.get_contractual_month(sd.getSeqOrigDate(), response);

        if (!response.getStatus().equalsIgnoreCase("Failed")) {

            final List<SequenceInfoKeyResponse> seqResp = ccs.get_Seq_details(sd, response, contractualmonth);

            if (!(response.getStatus().equalsIgnoreCase("Failed")) && seqResp != null)// get LLL
                                                                                      // legs to
                                                                                      // process
            {
                final int lll_index = ccs.getLastIndexInfo(seqResp);
                final FlightLegs FL = ccs.getFlightlegs();
                final FlightLegs FL2 = ccs.getFlightlegs2();

                System.out.println("Leg index in main pgm = " + lll_index);

                if (lll_index == 99) {
                    response.setStatus(" Failed");
                    response.setResponse("Sequence not eligible for trade ");
                } else {

                    // populate data for QLA
                    final List<QlaResponsePayload> qlaResp = map_QLA_EmpData.map_CCS_QLA_EmpData(seqResp, sd,
                        contractualmonth, FL2, response);
                    System.out.println(" QLA Employee data in main pgm :::: " + qlaResp);
                    if (!(response.getStatus().equalsIgnoreCase("Failed")) && qlaResp != null)// QLA
                                                                                              // response
                                                                                              // is
                                                                                              // successful
                    {
                        final String faLegalToTrade = qvl.validateLegality(qlaResp);

                        System.out.println("Legality check is = " + faLegalToTrade);

                        if (faLegalToTrade.equalsIgnoreCase("Legal")) {

                            System.out.println(map_QLA_EmpData.getQlas());

                            if (map_QLA_EmpData.getQlas() != null) {
                                final ObjectMapper mapper = new ObjectMapper();
                                mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                                final List<QLARequestPayload> qlaReq = mapper.readValue(map_QLA_EmpData.getQlas(),
                                    new TypeReference<List<QLARequestPayload>>() {
                                    });
                                /*------------------------------CALLING OPSHUB SERVICES FOR TRADE-----------------------------*/
                                OpshubCreateResponse creatresponse = new OpshubCreateResponse();
                                final String modresponse = seqmod.sequencemodificationservice(sd, FL, response);

                                if (modresponse.equals("OK")) // modification successful ?
                                {
                                    TimeUnit.SECONDS.sleep(1); // wait for next transaction.
                                    creatresponse = seqCre.sequence_Creation(FL, qlaReq, sd.getPosition(), response); // create
                                    // new
                                    // sequence
                                    if (creatresponse != null) // sequence creation successful ?
                                    {
                                        TimeUnit.SECONDS.sleep(1); // wait for previous transaction
                                                                   // to complete
                                        final String assignresponse = seqAssign.assign_Sequence(sd, creatresponse,
                                            response); // assign FA2 on new sequence
                                        if (assignresponse.contains("OK")) // sequence assignment
                                                                           // successful ?
                                        {
                                            System.out.println("LLL trade successful" + seqAssign.getSeqno() + "/"
                                                    + seqAssign.getSeqdate()); // update log
                                            response.setStatus("success"); // update return status
                                            response.setResponse(seqAssign.getSeqno() + "/" + seqAssign.getSeqdate()); // update
                                            // seq# and Seq. date
                                        } else {
                                            TimeUnit.SECONDS.sleep(1); // wait for previous
                                                                       // transaction to complete

                                            String delseqresponse = "RPT";
                                            int delcount = 0;
                                            while (delseqresponse.equals("RPT") && (delcount < 5)) {
                                                delseqresponse = seqDel.sequence_deletion(creatresponse, response); // delete
                                                delcount = delcount + 1;
                                            }
                                            if (delseqresponse.equals("OK")) {

                                                final String revmodresponse = revseqmod
                                                    .revSequencemodificationservice(sd, FL, response); // revert
                                                                                                       // back
                                                                                                       // original
                                                                                                       // sequence
                                                if (revmodresponse.equals("OK")) {
                                                    response.setStatus("Failed"); // update return
                                                                                  // status
                                                    response.setResponse("FOS failed to trade "
                                                            + "and newly created sequence " + seqAssign.getSeqno() + "/"
                                                            + seqAssign.getSeqdate() + " is deleted successfully "); // update
                                                    // return
                                                    // message
                                                } else {
                                                    response.setStatus("Failed");
                                                    response.setResponse(
                                                        "Opshub failed to revert original sequence. Please handle manually/n error:"
                                                                + revmodresponse);

                                                }
                                            } else {
                                                response.setStatus("Failed"); // update return
                                                                              // status
                                                response.setResponse(
                                                    "Opshub delete sequence transaction failed , Please delete"
                                                            + seqAssign.getSeqno() + "/" + seqAssign.getSeqdate()
                                                            + " new sequence and revert original sequence manually"); // update
                                            }
                                        }

                                    } else {
                                        TimeUnit.SECONDS.sleep(1); // wait for previous transaction
                                                                   // to complete
                                        final String revmodresponse = revseqmod.revSequencemodificationservice(sd, FL,
                                            response); // revert back to original state

                                        if (revmodresponse.equals("OK")) {

                                            response.setStatus("Failed"); // update return status
                                            response.setResponse(
                                                "Opshub replacement sequence creation failed , Please handle manually"
                                                        + creatresponse); // update
                                        } else {
                                            response.setStatus("Failed"); // update return status
                                            response.setResponse(
                                                "Opshub revert modification to original state failed , Please handle manually"
                                                        + revmodresponse); // update
                                        }
                                        // return
                                        // message
                                    }

                                } else {
                                    response.setStatus("Failed"); // update return status
                                    response.setResponse(
                                        "could not alter original sequence due to the reason:" + modresponse); // update
                                                                                                               // return
                                                                                                               // message
                                }
                                /*---------------------------------------------------------------------------------------*/
                            } else {
                                response.setStatus("Failed");
                                response.setResponse("Not Legal ::" + faLegalToTrade);
                            }
                        } else {
                            response.setStatus("Failed");
                            response.setResponse(faLegalToTrade);
                            System.out.println("Not valid QLA input");
                        }
                    }
                }
            }

        }
                
        } catch (Exception e) {response.setStatus("failed"); response.setResponse("LLL internal error.  please contact support team");
        final StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        final String exceptionAsString = sw.toString();
        System.out.println(exceptionAsString);
        }
                    
        System.out.println(response);
        return CompletableFuture.completedFuture(response);
    }
}
