/**
 * Developed by:- Snehal Dabre/Sivan Kumar.
 * Modified date:-  May/2021
 * Description:-This file has business functions to create new sequence with Last live leg. 
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

import com.aa.ccsservices.CCS_getSequenceDetailsByKeysNew;
import com.aa.connection.CommonConnection;
import com.aa.entities.ResponseEntity;
import com.aa.entities.opshubCreateRequest.Add;
import com.aa.entities.opshubCreateRequest.Close;
import com.aa.entities.opshubCreateRequest.CloseMode;
import com.aa.entities.opshubCreateRequest.Common;
import com.aa.entities.opshubCreateRequest.CreateDomesticSequence;
import com.aa.entities.opshubCreateRequest.CreateSequence;
import com.aa.entities.opshubCreateRequest.Credentials;
import com.aa.entities.opshubCreateRequest.NormalFlightLeg;
import com.aa.entities.opshubCreateRequest.OH_DepartureTime;
import com.aa.entities.opshubCreateRequest.OaldeadHead1;
import com.aa.entities.opshubCreateRequest.OpshubCreateRequest;
import com.aa.entities.opshubCreateRequest.ReportLeg;
import com.aa.entities.opshubCreateRequest.Requests;
import com.aa.entities.opshubCreateResponse.OpshubCreateResponse;
import com.aa.entities.qlarequest.FlightLegs;
import com.aa.entities.qlarequest.QLARequestPayload;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
//@PropertySource(value = { "application.properties" })
public class SequenceCreateService {

	@Autowired
	private CommonConnection commonconnection;

	@Value("${tdec.OpsHub.Create.Endpoint}")
	private String service_name;

	@Value("${Functionalgrp}")
	private String aliasgrpname;

	/**
	 * @author sdabre, skumar
	 * @param FL
	 * @param qlaRequest
	 * @param pos
	 * @param response
	 * @return response or null.
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

	public synchronized OpshubCreateResponse sequence_Creation(final FlightLegs FL,
			final List<QLARequestPayload> qlaRequest, final String pos, final ResponseEntity response)
			throws NoSuchFieldException, ParseException, KeyManagementException, UnrecoverableKeyException,
			NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException,
			org.apache.tomcat.util.json.ParseException {

		OpshubCreateRequest seqeunceCreate = new OpshubCreateRequest();
		String status = "NOTOKAY";
		/*
		 * *** Build JASON OBJECT to Get Sequence details
		 *************/
		seqeunceCreate = getObjectData(seqeunceCreate, qlaRequest, FL, pos);
		// System.out.println("CSS Request:" + sequenceByKeysRequest);

		// Creating Object of ObjectMapper define in Jakson Api
		final ObjectMapper Obj = new ObjectMapper();

		// get Origination object as a json string
		final String jsonStr = Obj.writeValueAsString(seqeunceCreate);

		// Displaying JSON String
		// JSONObject jsonObj = new JSONObject();
		final JSONParser parser = new JSONParser();
		final JSONObject json = (JSONObject) parser.parse(jsonStr);

		System.out.println("************CREATE REPLACEMENT SEQUENCE*************");
		final String server_name = "OPSHUB";
		final String resString = commonconnection.json_response(server_name, service_name, json, response);

		/************** Develop by snehal ****************/

		final ObjectMapper objMap = new ObjectMapper();
		final OpshubCreateResponse opsResponse = objMap.readValue(resString, OpshubCreateResponse.class);

		final String seqno = opsResponse.getReplies().getEndTransaction().getValue();

		status = opsResponse.getReplies().getEndTransaction().getValue();

		if (status.contains("OK")) {
			return opsResponse;

		} else {

			return null;
		}

	}

	/**
	 * @author sdabre, skumar
	 * @param req
	 * @param qlaRequest
	 * @param FL
	 * @param pos
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
	public OpshubCreateRequest getObjectData(final OpshubCreateRequest req, final List<QLARequestPayload> qlaRequest,
			final FlightLegs FL, final String pos)
			throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException, NoSuchAlgorithmException,
			KeyStoreException, CertificateException, IOException, ParseException {
		// Insert the data
		req.setAcknowledgment("ALL");
		req.setSourceSystem("PROD");

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		final String gmtStrDate = sdf.format(Calendar.getInstance().getTime());

		req.setSourceTimeStamp(gmtStrDate);

		final Credentials cred = new Credentials();
		req.setCredentials(cred);
		cred.setAlias(aliasgrpname);

		final Requests crereq = new Requests();
		req.setRequests(crereq);

		final Common com = new Common();
		com.setPartitionCode("AA");
		crereq.setCommon(com);

		final CreateSequence creSeq = new CreateSequence();
		crereq.setCreateSequence(creSeq);

		final CreateDomesticSequence creDoms = new CreateDomesticSequence();
		// // crew base

		creDoms.setCrewBase(qlaRequest.get(0).getProjectedData().getSequenceDetails().get(0).getBase()); // crew
																											// base
		creDoms.setEquipmentGroup(
				qlaRequest.get(0).getProjectedData().getSequenceDetails().get(0).getEquipmentGroups().get(0)); // equipment
		// code
		creDoms.setSeqOrgDate(qlaRequest.get(0).getEmployees().get(0).getRequests().get(0).getPickupDutyList().get(0)
				.getActivityOriginationDate());

		creSeq.setCreateDomesticSequence(creDoms);

		crereq.setEndTransaction(true);

		final Close cl = new Close();
		crereq.setClose(cl);

		final CloseMode clm = new CloseMode();
		clm.setPosition(pos);
		cl.setCloseMode(clm);

		int index = 0;
		int totalSize = FL.getItems().size();

		final List<Add> addleg = new ArrayList<Add>();

		final Add addleg1 = new Add();
		final ReportLeg rpt = new ReportLeg();

		rpt.setDepartureStation(FL.getItems().get(0).getFlightKey().getDepartureAirport());
		rpt.setArrivalStation(FL.getItems().get(0).getFlightKey().getDepartureAirport());
		rpt.setOalflightLegDate(qlaRequest.get(0).getEmployees().get(0).getRequests().get(0).getPickupDutyList().get(0)
				.getActivityOriginationDate());

		final String str = String.valueOf(qlaRequest.get(0).getProjectedData().getSequenceDetails().get(0)
				.getDutyPeriods().getItems().get(0).getFdpStartTime().getLocalTime());
		final String[] arrOfStr = str.split("T", 2);

		final String str1 = arrOfStr[1];

		final String str2 = str1 + ":00";

		rpt.setOaldepartureTime(str2); // need see
		rpt.setElapsedTime("PT00H00M");
		addleg1.setReportLeg(rpt);
		addleg.add(addleg1);

		while (totalSize != 0) {
			final Add addleg2 = new Add();
			if (!(FL.getItems().get(index).getOalSurfaceAirline().isBlank()))

			{
				final OaldeadHead1 oald = new OaldeadHead1();
				oald.setArrivalStation(FL.getItems().get(index).getArrivalAirport());
				oald.setDepartureStation(FL.getItems().get(index).getFlightKey().getDepartureAirport());
				oald.setIdPlusFlighNum(FL.getItems().get(index).getOalSurfaceAirline()
						+ FL.getItems().get(index).getFlightKey().getFlightNumber());

				oald.setOalflightLegDate(FL.getItems().get(index).getFlightKey().getFlightOriginationDate());

				final String strtime = FL.getItems().get(index).getArrivalTime().getScheduled().getLocalTime();

				oald.setOalarrivalTime(strtime);

				final String strtime1 = FL.getItems().get(index).getDepartureTime().getScheduled().getLocalTime();

				oald.setOaldepartureTime(strtime1);

				addleg2.setOaldeadHead1(oald);
			} else {
				final NormalFlightLeg norm = new NormalFlightLeg();

				build_flight_details(FL, norm, index);
				addleg2.setNormalFlightLeg(norm);
			}
			index = index + 1;
			totalSize = totalSize - 1;
			addleg.add(addleg2);

		}
		crereq.setAdd(addleg);

		return req;
	}

	/**
	 * @author sdabre, skumar
	 * @param FL
	 * @param norm
	 * @param index
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchFieldException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws ParseException
	 * @throws IOException
	 */

	// build flight details , in fos H5/H7 entry.

	public void build_flight_details(final FlightLegs FL, final NormalFlightLeg norm, final int index)
			throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException, NoSuchAlgorithmException,
			KeyStoreException, CertificateException, ParseException, IOException {

		if (FL.getItems().get(index).isDeadHead()) {
			norm.setDeadHeadNormalCockpit("A");
		} else {
			norm.setDeadHeadNormalCockpit(null);
		}
		norm.setDepartureStation(FL.getItems().get(index).getFlightKey().getDepartureAirport());
		final OH_DepartureTime OHD = new OH_DepartureTime();
		norm.setDepartureTime(OHD);

		final String str = String.valueOf((FL.getItems().get(index).getDepartureTime().getScheduled().getLocalTime()));
		final String[] arrOfStr = str.split("T", 2);

		OHD.setValue(arrOfStr[1]);
		norm.setFlightNumber(FL.getItems().get(index).getFlightKey().getFlightNumber());
		norm.setFlightOriginDate(FL.getItems().get(index).getFlightKey().getFlightOriginationDate());

	}
}
