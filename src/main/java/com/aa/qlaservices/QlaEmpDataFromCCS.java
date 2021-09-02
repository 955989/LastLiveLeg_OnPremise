/**
 * @author skumar
 * Get QLA employee details from CCS
 */

package com.aa.qlaservices;

/*Developed by RitikaSwami*/
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aa.ccsservices.CCS_getCrewMember;
import com.aa.connection.CommonConnection;
import com.aa.entities.ResponseEntity;
import com.aa.entities.SequenceDetailsEntity;
import com.aa.entities.ccsResponse.SequenceInfoKeyResponse;
import com.aa.entities.qlarequest.DutyPeriods;
import com.aa.entities.qlarequest.Employee;
import com.aa.entities.qlarequest.FlightLegs;
import com.aa.entities.qlarequest.LanguageRequirement;
import com.aa.entities.qlarequest.PickupDutyList;
import com.aa.entities.qlarequest.ProjectedData;
import com.aa.entities.qlarequest.QLARequestPayload;
import com.aa.entities.qlarequest.Request;
import com.aa.entities.qlarequest.SeqProperties;
import com.aa.entities.qlarequest.SequenceDetail;
import com.aa.entities.qlarequest.SequenceInfoKey;
import com.aa.entities.qlarequest.SequencePayCredit;
import com.aa.entities.qlaresponse.QlaResponsePayload;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service

public class QlaEmpDataFromCCS {
    @JsonIgnoreProperties

    @Autowired
    private QLA_Build_DutyPeriods buildDuty;

    @Autowired
    private CommonConnection commonconnection;

    @Autowired
    private CCS_getCrewMember ccsMem;

    @Value("${tdec.QLAValidateFA_EndPoint}")
    private String service_name;

    private String qlas;

    
    /**
     * @author skumar
     * @param ccsResponse
     * @param sd
     * @param contractualmonth
     * @param FL
     * @param response
     * @return
     * @throws ParseException
     * @throws KeyManagementException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws IOException
     * @throws KeyStoreException
     * @throws IOException
     * @throws NoSuchFieldException
     */
    public List<QlaResponsePayload> map_CCS_QLA_EmpData(final List<SequenceInfoKeyResponse> ccsResponse,
            final SequenceDetailsEntity sd, final String contractualmonth, final FlightLegs FL, final ResponseEntity response)
            throws ParseException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException,
            CertificateException, IOException, KeyStoreException, IOException, NoSuchFieldException {

        final String base = ccsMem.get_emp_details(sd, response, contractualmonth);
        System.out.println(" Emp 2 base needed for seq creation :::::::::: :::" + base);

        if (base != null) {

            final QLARequestPayload qla = new QLARequestPayload();
            final List<QLARequestPayload> qlaEmpData = new ArrayList<QLARequestPayload>();

            final List<Employee> employees = new ArrayList<Employee>();
            qlaEmpData.add(qla);

            final Employee emp = new Employee();
            employees.add(emp);
            emp.setEmployeeID(sd.getFa2ID());
            emp.setAirlineCode("AA");

            final List<Request> requests = new ArrayList();
            final Request request = new Request();

            request.setRequestId(1);
            // request.dropDutyList(null);
            final PickupDutyList pickUpDuty = new PickupDutyList();

            pickUpDuty.setActivityId(1234);

            pickUpDuty.setActivityType("SEQ");
            pickUpDuty.setAirlineCode("AA");
            pickUpDuty.setPositionCode(sd.getPosition());

            request.setPickupDutyList(Arrays.asList(pickUpDuty));
            requests.add(request);

            emp.setRequests(requests);

            qla.setEmployees(employees);
            qla.setOptimizeRules("false");

            // ----------------------

            final ProjectedData projectedData = new ProjectedData();

            qlaEmpData.get(0).setProjectedData(projectedData);

            final List<SequenceDetail> sequenceDetails = new ArrayList<SequenceDetail>();
            final SequenceDetail sequenceDet = new SequenceDetail();
            projectedData.setSequenceDetails(sequenceDetails);
            sequenceDetails.add(sequenceDet);

            final SequenceInfoKeyResponse ccsResponseData = ccsResponse.get(0);

            sequenceDet.setAddCode("LL");
            sequenceDet.setEquipmentGroups(Arrays.asList(ccsResponseData.getEquipmentGroup()));

            sequenceDet.setBase(base);
            sequenceDet.setCabinType(ccsResponseData.getCabinType());
            sequenceDet.setCoterminal(ccsResponseData.getIsCoterminal());
            sequenceDet.setDivisionType(ccsResponseData.getDivision());

            // Get Duty period

            final DutyPeriods dutyPeriods = buildDuty.build_DP(FL, sd.getPosition());

            sequenceDet.setDutyPeriods(dutyPeriods); // Get duty period object here

            pickUpDuty.setContractMonth(dutyPeriods.getItems().get(0).getFlightDutyPeriodKey().getContractMonth());
            pickUpDuty.setActivityOriginationDate(
                dutyPeriods.getItems().get(0).getFlightDutyPeriodKey().getOriginationDate());

            sequenceDet.setEndDateTime(ccsResponseData.getSequenceEndDateTime().getGmt()); // SK
                                                                                           // changed
                                                                                           // from
                                                                                           // local
                                                                                           // to gmt
            sequenceDet.setEndDateTimeInBaseTime(ccsResponseData.getSequenceEndDateTime().getBaseTime());
            sequenceDet.setEndDateTimeInGmt(ccsResponseData.getSequenceEndDateTime().getGmt());
            sequenceDet.setFirstLegDHD(ccsResponseData.getFirstLegDeadHeadIndicator());
            sequenceDet.setFirstLegDepAirport(ccsResponseData.getFirstLegDepartureAirport());

            sequenceDet.setFlightLegs(FL); // GEt flight leg object here

            sequenceDet.setGalleyPosition(ccsResponseData.getGalleyPosition());
            sequenceDet.setInternational(ccsResponseData.getInternational());
            sequenceDet.setIpd(ccsResponseData.getIsIPD());
            sequenceDet.setLandingQuals(ccsResponseData.getLandingQuals());

            // populate language code
            final List<LanguageRequirement> languageRequirements = new ArrayList<LanguageRequirement>();

            final LanguageRequirement LangReq = new LanguageRequirement();
            LangReq.setLangCode(null);
            LangReq.setLangCount(0);
            languageRequirements.add(LangReq);

            sequenceDet.setLanguageRequirements(languageRequirements);

            //

            sequenceDet.setLastLegArrivalAirport(ccsResponseData.getLastLegArrivalAirport());
            sequenceDet.setLastLegDHD(ccsResponseData.getLastLegDeadHeadIndicator());

            sequenceDet.setNipd(ccsResponseData.isNIPD());
            sequenceDet.setOdan(ccsResponseData.getIsODAN());
            sequenceDet.setPosLangQual(null);
            sequenceDet.setPosSpeakerRestricted(ccsResponseData.getSpeakerRequirement().isPosSpeakerRestricted());
            sequenceDet.setPurser(ccsResponseData.isPurser());
            sequenceDet.setRedEye(ccsResponseData.getIsRedEye());
            sequenceDet.setSatellite(ccsResponseData.getIsSatellite());

            // Set property

            final SeqProperties seqProperties = new SeqProperties();
            seqProperties.isAdvIndicator();
            seqProperties.isCfdIndicator();

            sequenceDet.setSeqProperties(seqProperties);

            // Sequence Info key
            final SequenceInfoKey sequenceInfoKey = new SequenceInfoKey();
            sequenceInfoKey.setAirlineCode(ccsResponseData.getAirlineCode());
            sequenceInfoKey.setBaseIndicator(" ");
            sequenceInfoKey.setContractMonth(dutyPeriods.getItems().get(0).getFlightDutyPeriodKey().getContractMonth());
            sequenceInfoKey
                .setOriginationDate(dutyPeriods.getItems().get(0).getFlightDutyPeriodKey().getOriginationDate());

            sequenceInfoKey.setPositionCode(ccsResponseData.getPositionCode());
            sequenceInfoKey.setSequenceNumber(1234);

            sequenceDet.setSequenceInfoKey(sequenceInfoKey);

            final SequencePayCredit sequencePayCredit = new SequencePayCredit();
            sequencePayCredit.setActualSeqCredit(0); // check with QLA team
            sequencePayCredit.setScheduledSeqCredit(0);// check this with QLA ..... need more fields
                                                       // here
            sequencePayCredit.setActualBlockTime(0);

            sequenceDet.setSequencePayCredit(sequencePayCredit);

            sequenceDet.setSequenceStatus(ccsResponseData.getSequenceStatus());

            sequenceDet
                .setStartDateTimeInBaseTime(FL.getItems().get(0).getDepartureTime().getScheduled().getBaseTime());

            sequenceDet.setStartDateTime(FL.getItems().get(0).getDepartureTime().getScheduled().getGmt());

            sequenceDet.setTotalMissingForCabin(ccsResponseData.getSpeakerRequirement().getTotalMissingForCabin());
            sequenceDet.setTotalMissingForSeq(ccsResponseData.getSpeakerRequirement().getTotalMissingForSeq());
            sequenceDet.setTotalOpenPositionsForCabin(ccsResponseData.getTotalOpenPositionsForCabin());
            sequenceDet.setTotalOpenPositionsForSeq(ccsResponseData.getTotalOpenPositionsForSeq());
            sequenceDet.setTotalRequiredForCabin(ccsResponseData.getSpeakerRequirement().getTotalRequiredForCabin());
            sequenceDet.setTotalRequiredForSeq(ccsResponseData.getSpeakerRequirement().getTotalRequiredForSeq());
            sequenceDet.setType("F");
            sequenceDet.setCreditThisMonth(ccsResponseData.getCreditThisMonth());// WONT IT BE
                                                                                 // CREDIT FOR FA 2
            sequenceDet.setStartDateTimeInGmt(FL.getItems().get(0).getDepartureTime().getScheduled().getGmt());

            System.out.println(" QLA projected data in class :::: " + qlaEmpData);

            // Creating Object of ObjectMapper define in Jakson Api
            final ObjectMapper Obj = new ObjectMapper();

            final String jsonStr = Obj.writeValueAsString(qla);

            // Displaying JSON String
            System.out.println("QLA JASON payload :" + jsonStr);

            qlas = jsonStr;

            final JSONParser parser = new JSONParser();

            final JSONObject json = (JSONObject) parser.parse(jsonStr);

            System.out.println("json :::: " + json);

            final String server_name = "QLA";
            final String resString = commonconnection.json_response(server_name, service_name, json, response);

            /*******
             * Convert JASON String to JAVA Object entity
             *****************************/
            if (resString != null) {

                final ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                final List<QlaResponsePayload> jList = mapper.readValue(resString,
                    new TypeReference<List<QlaResponsePayload>>() {
                    });

                System.out.println(" QLA RESPONSE ******************************************************" + jList);
                return jList;

            }
        } else {
            response.setStatus("Failed");
            response.setResponse("Null returned from CCS - Invalid Replacement FA details ");
        }
        return null;

    }

    public String getQlas() {
        return qlas;
    }

    public void setQlas(final String qlas) {
        this.qlas = qlas;
    }

    /**
     * @return the qla
     */

}
