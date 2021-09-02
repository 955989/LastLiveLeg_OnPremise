/**
 * Developed by:- Snehal Dabre/Sivan Kumar.
 * Modified date:-  May/2021
 * Description:-This file has business functions to delete newly created sequence with Last live leg. 
 */

package com.aa.opshubservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import com.aa.entities.opshubCreateResponse.OpshubCreateResponse;
import com.aa.entities.opshubDelRequest.Credentials_del;
import com.aa.entities.opshubDelRequest.Request_del;
import com.aa.entities.opshubDelRequest.Root_del;
import com.aa.entities.opshubDelResponse.OpsHubDeleteResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
//@PropertySource(value = { "application.properties" })
public class SequenceDeleteService {

	@Autowired
	private CommonConnection commonconnection;

	@Value("${tdec.OpsHub.Del.Endpoint}")
	private String service_name;

	@Value("${Functionalgrp}")
	private String aliasgrpname;

	/**
	 * 
	 * @author sdabre, skumar
	 * @param opsResponse2
	 * @param response
	 * @return status
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
	public synchronized String sequence_deletion(final OpshubCreateResponse opsResponse2, final ResponseEntity response)
			throws NoSuchFieldException, ParseException, KeyManagementException, UnrecoverableKeyException,
			NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException,
			org.apache.tomcat.util.json.ParseException {

		String status = "NOTOKAY";
		Root_del seqeunceDel = new Root_del();
		seqeunceDel = getObjectData(seqeunceDel, opsResponse2);

		// Creating Object of ObjectMapper define in Jakson Api
		final ObjectMapper Obj = new ObjectMapper();

		// get Origination object as a json string
		final String jsonStr = Obj.writeValueAsString(seqeunceDel);

		// Displaying JSON String
		final JSONParser parser = new JSONParser();
		final JSONObject json = (JSONObject) parser.parse(jsonStr);

		System.out.println("************OPSHUB DELETE TRANSACTION*************");
		final String server_name = "OPSHUB";
		final String resString = commonconnection.json_response(server_name, service_name, json, response);

		/************** Response ****************/

		final ObjectMapper objMap = new ObjectMapper();
		final OpsHubDeleteResponse opsResponse = objMap.readValue(resString, OpsHubDeleteResponse.class);

		status = opsResponse.getReply().getData();
		if (status.contains("LEGS")) {

			status = "OK";

		} else if (status.contains("FIN OR IG OR KIG")) {

			status = "RPT";

		}
		System.out.println("Status:" + status);
		return status;

	}

	/**
	 * 
	 * @author sdabre, skumar
	 * @param req
	 * @param opsResponse2
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
	public Root_del getObjectData(final Root_del req, final OpshubCreateResponse opsResponse2)
			throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException, NoSuchAlgorithmException,
			KeyStoreException, CertificateException, IOException, ParseException {

		req.setAcknowledgment("ALL");
		req.setSourceSystem("PROD");

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		final String gmtStrDate = sdf.format(Calendar.getInstance().getTime());

		req.setSourceTimeStamp(gmtStrDate);

		final Credentials_del cred = new Credentials_del();
		req.setCredentials(cred);
		cred.setAlias(aliasgrpname);

		final Request_del delr = new Request_del();
		req.setRequest(delr);

		final String seqno = opsResponse2.getReplies().getEndTransaction().getValue();
		final String[] arrOfStr = seqno.split(" ", 3);
		final String str1 = arrOfStr[2];
		final String[] arrOfStr1 = str1.split("/", 2);

		delr.setSequenceNumber(arrOfStr1[0]);
		delr.setSeqOrgDate(opsResponse2.getRequests().getCreateSequence().getCreateDomesticSequence().getSeqOrgDate());

		final List<String> position = new ArrayList<String>();

		position.add((opsResponse2.getRequests().getClose().getCloseMode().getPosition()));
		delr.setPosition(position);
		delr.setTransaction(true);
		delr.setCommit(true);

		return req;
	}

}
