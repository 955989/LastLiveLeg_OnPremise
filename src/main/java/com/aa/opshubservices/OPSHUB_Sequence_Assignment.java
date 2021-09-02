/**
 * Developed by:- Sivan Kumar/Snehal Dabre.
 * Modified date:-  May/2021
 * Description:-This file has business functions to assign replacement FA to newly created sequence.
 */

package com.aa.opshubservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.aa.connection.CommonConnection;
import com.aa.entities.ResponseEntity;
import com.aa.entities.SequenceDetailsEntity;
import com.aa.entities.opshubCreateResponse.OpshubCreateResponse;
import com.aa.entities.opshubassignRequest.OPSHUBSequenceAssignmentEntity;
import com.aa.entities.opshubassignRequest.OpshubAssign;
import com.aa.entities.opshubassignRequest.OpshubCredentials;
import com.aa.entities.opshubassignRequest.OpshubRequest;
import com.aa.entities.opshubassignResponse.OpshubResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
//@PropertySource(value = { "application.properties" })
public class OPSHUB_Sequence_Assignment {

	@Autowired
	private CommonConnection commonconnection;

	@Value("${tdec.OpsHub.Assign.Endpoint}")
	private String service_name;

	@Value("${Functionalgrp}")
	private String aliasgrpname;

	private String seqno, seqdate;

	public String getSeqno() {
		return seqno;
	}

	public void setSeqno(final String seqno) {
		this.seqno = seqno;
	}

	public String getSeqdate() {
		return seqdate;
	}

	public void setSeqdate(final String seqdate) {
		this.seqdate = seqdate;
	}

	/**
	 * 
	 * @author sdabre, skumar
	 * @param sd
	 * @param opsResponse2
	 * @param response
	 * @return status -> okay or not okay
	 * @throws NoSuchFieldException
	 * @throws ParseException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws org.apache.tomcat.util.json.ParseException
	 */
	// This method will call "getobjectdata" build request schema and call common
	// connection to call
	// OPS HUB service to assign newly created sequence with LL action code.

	public synchronized String assign_Sequence(final SequenceDetailsEntity sd, final OpshubCreateResponse opsResponse2,
			final ResponseEntity response) throws NoSuchFieldException, ParseException, KeyManagementException,
			UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException,
			org.apache.tomcat.util.json.ParseException {

		String status = "NOTOKAY"; // by default it is NOTOKAY

		OPSHUBSequenceAssignmentEntity seqeunceAssign = new OPSHUBSequenceAssignmentEntity();

		seqeunceAssign = getObjectData(seqeunceAssign, opsResponse2, sd); // Build request

		seqno = seqeunceAssign.getRequest().getAssign().getSequenceNumber(); // Get sequence number
		seqdate = seqeunceAssign.getRequest().getAssign().getSequenceOriginDate(); // Get Sequence Date

		System.out.println("building sequence opshub request..");

		// Creating Object of ObjectMapper define in Jakson Api
		final ObjectMapper obj = new ObjectMapper();

		// get Origination object as a json string
		final String jsonStr = obj.writeValueAsString(seqeunceAssign);

		// Displaying JSON String
		System.out.println("CCS JASON SEQ info by key :" + jsonStr);
		// JSONObject jsonObj = new JSONObject();
		final JSONParser parser = new JSONParser();
		final JSONObject json = (JSONObject) parser.parse(jsonStr);

		System.out.println("************ASSIGN REPLACEMENT FA TO NEW SEQUENCE *************");
		final String server_name = "OPSHUB";
		final String resString = commonconnection.json_response(server_name, service_name, json, response);

		/************** Response ****************/

		final ObjectMapper objMap = new ObjectMapper();
		final OpshubResponse opsResponse = objMap.readValue(resString, OpshubResponse.class);

		status = opsResponse.getReply().getStatus(); // Get status from response.
		if (status.contains("ok")) { // All OK?
			status = "OK"; // yes send "OK" back
		} else { // else

			status = opsResponse.getReply().getData(); // Get error message and send back
		}

		return status; // It will hold "OK" if able to assign
						// else error message in case of failure.
	}

	/**
	 * @author sdabre, skumar
	 * @param req
	 * @param opsResponse2
	 * @param sd
	 * @return req
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchFieldException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws ParseException
	 */
	// Description:- This function will build complete request schema
	public OPSHUBSequenceAssignmentEntity getObjectData(final OPSHUBSequenceAssignmentEntity req,
			final OpshubCreateResponse opsResponse2, final SequenceDetailsEntity sd)
			throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException, NoSuchAlgorithmException,
			KeyStoreException, CertificateException, IOException, ParseException {

		req.setAcknowledgment("ALL");
		req.setSourceSystem("PROD");
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		final String gmtStrDate = sdf.format(Calendar.getInstance().getTime());
		req.setSourceTimeStamp(gmtStrDate);

		final OpshubCredentials cred = new OpshubCredentials();
		cred.setAlias(aliasgrpname);
		req.setCredentials(cred);

		final OpshubAssign opas = new OpshubAssign();
		opas.setEmployeeNumber(sd.getFa2ID());
		opas.setReasonCode("LL"); // Last Live add code
		opas.setSeat(sd.getPosition()); // Get sequence position
		final String seqno = opsResponse2.getReplies().getEndTransaction().getValue(); // get newly created sequence
																						// number
		final String[] arrOfStr = seqno.split(" ", 3); // split string received from sequence creation and get sequence
														// number
		final String str1 = arrOfStr[2];
		final String[] arrOfStr1 = str1.split("/", 2);

		opas.setSequenceNumber(arrOfStr1[0]); // sequence number
		opas.setSequenceOriginDate(
				opsResponse2.getRequests().getCreateSequence().getCreateDomesticSequence().getSeqOrgDate()); // sequence
																												// date

		final OpshubRequest Opreq = new OpshubRequest();
		Opreq.setAssign(opas);
		Opreq.setCommit(true);
		Opreq.setTransaction(true);

		req.setRequest(Opreq);

		return req;
	}

}
