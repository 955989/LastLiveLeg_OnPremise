/**
 * Developed by:- Snehal Dabre.
 * Modified date:-  May/2021
 * Description:- This file has business functions to modify original sequence to original state. 
 * We need to remove legs which was added with LL id and replace with original legs.
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

import org.apache.commons.lang3.StringUtils;
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
import com.aa.entities.SequenceDetailsEntity;
import com.aa.entities.opshub.AddLeg;
import com.aa.entities.opshub.CloseEntry;
import com.aa.entities.opshub.CloseMode;
import com.aa.entities.opshub.CommonPartition;
import com.aa.entities.opshub.Credentials;
import com.aa.entities.opshub.DeleteLeg;
import com.aa.entities.opshub.ModRequests;
import com.aa.entities.opshub.ModifyNormalSequence;
import com.aa.entities.opshub.NormalFlightLeg;
import com.aa.entities.opshub.OaldeadHead;
import com.aa.entities.opshub.OaldeadHeaddel;
import com.aa.entities.opshub.OpenConverstionMode;
import com.aa.entities.opshub.SequenceModificationOps;
import com.aa.entities.opshubresponse.OpshubModificationRes;
import com.aa.entities.qlarequest.FlightLegs;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1

@Service
//@PropertySource(value = { "application.properties" })

public class RevertModificationService {

	@Autowired
	private CommonConnection commonconnection;

//	@Autowired
//	private CCS_getSequenceDetailsByKeysNew ccs;

	@Value("${tdec.OpsHub.Mod.Endpoint}")
	private String service_name;

	@Value("${Functionalgrp}")
	private String aliasgrpname;

	/**
	 * 
	 * @author sdabre
	 * @param sd
	 * @param FL
	 * @param response
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws ParseException
	 */
	public synchronized String revSequencemodificationservice(final SequenceDetailsEntity sd, final FlightLegs FL,
			final ResponseEntity response)
			throws NoSuchFieldException, IOException, KeyManagementException, UnrecoverableKeyException,
			NoSuchAlgorithmException, KeyStoreException, CertificateException, ParseException {

		/*
		 * *** Build JASON OBJECT to Get Sequence details
		 */
		String status = "NOTOKAY";
		SequenceModificationOps seqeunceModification = new SequenceModificationOps();
		seqeunceModification = getObjectData(seqeunceModification, sd, FL); // Build modification request

		// Creating Object of ObjectMapper define in Jakson Api
		final ObjectMapper obj = new ObjectMapper();

		// get Origination object as a json string
		final String jsonStr = obj.writeValueAsString(seqeunceModification);

		// Displaying JSON String
		final JSONParser parser = new JSONParser();
		final JSONObject json = (JSONObject) parser.parse(jsonStr);

		System.out.println("************REVERT ORIGINAL SEQUNECE TO ITS ORIGINAL STATE*************");
		final String server_name = "OPSHUB";
		final String resString = commonconnection.json_response(server_name, service_name, json, response);

		/************** Develop by snehal ****************/

		final ObjectMapper objMap = new ObjectMapper();
		final OpshubModificationRes opsResponse = objMap.readValue(resString, OpshubModificationRes.class);

		status = opsResponse.getReplies().getEndTransaction().getValue(); // Get reply from
		if (status.contains("OK")) {

			status = "OK";

		} else {

			status = opsResponse.getReplies().getClose().getValue();

		}

		return status;

	}

	
	/**
	 * @author sdabre
	 * @param req
	 * @param sd
	 * @param FL
	 * @return
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchFieldException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws ParseException
	 */
	public SequenceModificationOps getObjectData(final SequenceModificationOps req, final SequenceDetailsEntity sd,
			final FlightLegs FL) throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException,
			NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, ParseException {
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

		final ModRequests modr = new ModRequests();
		req.setModrequests(modr);

		final CommonPartition Comp = new CommonPartition();
		modr.setCommonpartiotion(Comp);
		Comp.setPartitionCode("AA");

		final OpenConverstionMode opc = new OpenConverstionMode();
		modr.setOpenConverstionMode(opc);

		final ModifyNormalSequence modnseq = new ModifyNormalSequence();
		opc.setModifyNormalSequence(modnseq);

		modnseq.setAddReasonCode("25");
		modnseq.setRemoveReasonCode("15");
		final String leftPaddedseq = StringUtils.leftPad(sd.getSequenceNum(), 5, "0");

		modnseq.setSeqNum(leftPaddedseq);
		modnseq.setSeqOrgDate(sd.getSeqOrigDate());

		int index = 0;
		int totalSize = FL.getItems().size();

		final List<AddLeg> addleg = new ArrayList<>();

		modr.setAddleg(addleg);

		final List<DeleteLeg> delleg = new ArrayList<DeleteLeg>();

		modr.setDeleteleg(delleg);

		while (totalSize != 0) {

			final DeleteLeg del = new DeleteLeg();
			final AddLeg addleg1 = new AddLeg();
			// NormalFlightLeg normf = new NormalFlightLeg();
			final OaldeadHeaddel oald = new OaldeadHeaddel();
			del.setOaldeadHeaddel(oald);

			/*************************************************************************************/

			oald.setArrivalStation(FL.getItems().get(index).getArrivalAirport());
			oald.setDepartureStation(FL.getItems().get(index).getFlightKey().getDepartureAirport());
			oald.setIdPlusFlighNum("LL" + String.valueOf(FL.getItems().get(index).getFlightKey().getFlightNumber()));

			oald.setOalflightLegDate(FL.getItems().get(index).getFlightKey().getFlightOriginationDate());

			/**********************************************************************************/

			// OaldeadHead oald = new OaldeadHead();
			// NormalFlightLeg normf = new NormalFlightLeg();

			/************************************************************************************/
			if ((FL.getItems().get(index).getOalSurfaceAirline().isBlank())) {

				final NormalFlightLeg normf = new NormalFlightLeg();
				addleg1.setNormalFlightLeg(normf);

				normf.setDepartureStation(FL.getItems().get(index).getFlightKey().getDepartureAirport());
				normf.setFlightNumber(String.valueOf(FL.getItems().get(index).getFlightKey().getFlightNumber()));
				normf.setFlightOriginDate(FL.getItems().get(index).getFlightKey().getFlightOriginationDate());
				if (FL.getItems().get(index).isDeadHead()) {
					normf.setDeadHeadNormalCockpit("A");
				} else {
					normf.setDeadHeadNormalCockpit(null);
				}

			} else {

				final OaldeadHead oaladd = new OaldeadHead();
				addleg1.setOaldeadHead(oaladd);
				oaladd.setArrivalStation(FL.getItems().get(index).getArrivalAirport());
				oaladd.setDepartureStation(FL.getItems().get(index).getFlightKey().getDepartureAirport());
				oaladd.setIdPlusFlighNum(FL.getItems().get(index).getOalSurfaceAirline()
						+ String.valueOf(FL.getItems().get(index).getFlightKey().getFlightNumber()));

				oaladd.setOalflightLegDate(FL.getItems().get(index).getFlightKey().getFlightOriginationDate());

				final String str = FL.getItems().get(index).getArrivalTime().getScheduled().getLocalTime();

				oaladd.setOalarrivalTime(str);

				final String str1 = FL.getItems().get(index).getDepartureTime().getScheduled().getLocalTime();

				oaladd.setOaldepartureTime(str1);

			}

			/*************************************************************************************/

			delleg.add(del);
			addleg.add(addleg1);
			index = index + 1;
			totalSize = totalSize - 1;

		}

		final CloseEntry clen = new CloseEntry();
		modr.setCloseentry(clen);

		final CloseMode clm = new CloseMode();
		clen.setCloseMode(clm);

		clm.setPosition(sd.getPosition());

		modr.setEndTransaction("true");

		return req;
	}

}
