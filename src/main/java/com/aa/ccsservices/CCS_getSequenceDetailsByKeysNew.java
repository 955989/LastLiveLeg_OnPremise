/**
* sivan kumar - validate sequence eligible or not to trade..
*             - populate flight details in QLA request
* Developed by RitikaSwami////
* This file has business functions to get Sequence details from CCS service
* allow only normal/deadhead/OAL dead heads. ignore other types of legs..//
* Enhanced by Snehal Dabre(@sd).
* Restrict Last Live Leg newly created sequence trade(@sd). 
*/

package com.aa.ccsservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.aa.connection.CommonConnection;
import com.aa.crew.apigee.AccessTokenClientImpl;
import com.aa.entities.ResponseEntity;
import com.aa.entities.SequenceDetailsEntity;
import com.aa.entities.ccsRequest.SequenceByKeysRequest;
import com.aa.entities.ccsResponse.Actual;
import com.aa.entities.ccsResponse.ArrivalDateTime;
import com.aa.entities.ccsResponse.DepartureDateTime;
import com.aa.entities.ccsResponse.EquipmentQuals;
import com.aa.entities.ccsResponse.FlightDutyPeriodDTO;
import com.aa.entities.ccsResponse.FlightLegDTO;
import com.aa.entities.ccsResponse.ReScheduled;
import com.aa.entities.ccsResponse.Scheduled;
import com.aa.entities.ccsResponse.SequenceInfoKeyResponse;
import com.aa.entities.qlarequest.ArrivalTime;
import com.aa.entities.qlarequest.DepartureTime;
import com.aa.entities.qlarequest.FlightKey;
import com.aa.entities.qlarequest.FlightLegStatusProperties;
import com.aa.entities.qlarequest.FlightLegs;
import com.aa.entities.qlarequest.LegItem;
import com.aa.entities.qlarequest.OalArrivalDateTime;
import com.aa.entities.qlarequest.OalDepartureDateTime;
import com.aa.entities.qlarequest.Scheduled2;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
//@PropertySource(value = { "application.properties" })

public class CCS_getSequenceDetailsByKeysNew {

	@Autowired
	private AccessTokenClientImpl accesstoken;

	@Autowired
	private CommonConnection commonconnection;

	@Autowired
	private CCS_Contractual_Month ccs;


	@Value("${tdec.CCS_EndPoint_Seq}")
	private String service_name;

	private FlightLegs flightlegs;

	private FlightLegs flightlegs2;

	/**
	 * Function returns sequence details
	 *
	 *@author 
	 * @param sd
	 * @param response
	 * @param contractualmonth
	 * @return Sequence pojo
	 * @throws NoSuchFieldException
	 * @throws ParseException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws IOException
	 */

	public List<SequenceInfoKeyResponse> get_Seq_details(final SequenceDetailsEntity sd, final ResponseEntity response,
			final String contractualmonth) throws NoSuchFieldException, ParseException, KeyManagementException,
			UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {

		// List<SequenceInfoKeyResponse> seqDetails = null;

		// seqDetails = call_CCS_Service_getSequenceDetails(sd, contractualmonth,
		// response);
		// return seqDetails;
		// }
		//
		// public List<SequenceInfoKeyResponse>
		// call_CCS_Service_getSequenceDetails(SequenceDetailsEntity sd, String
		// contractualMon,
		// ResponseEntity response)
		// throws NoSuchFieldException, IOException, KeyManagementException,
		// UnrecoverableKeyException,
		// NoSuchAlgorithmException, KeyStoreException, CertificateException,
		// ParseException {

		/**** Build JASON OBJECT to Get Sequence details *************/
		SequenceByKeysRequest sequenceByKeysRequest = new SequenceByKeysRequest();
		sequenceByKeysRequest = getObjectData(sequenceByKeysRequest, contractualmonth, sd);

		// Creating Object of ObjectMapper define in Jakson Api
		final ObjectMapper Obj = new ObjectMapper();
		// get Origination object as a json string

		final String jsonStr = Obj.writeValueAsString(sequenceByKeysRequest);

		// Displaying JSON String
		System.out.println("CCS JASON SEQ info by key :" + jsonStr);
		final JSONParser parser = new JSONParser();
		final JSONObject json = (JSONObject) parser.parse(jsonStr);

		final String server_name = "CCS";
		final String resString = commonconnection.json_response(server_name, service_name, json, response);

		// try {

		/*******
		 * Convert JASON String to JAVA Object entity
		 *****************************/
		if (resString != null) {

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

			final List<SequenceInfoKeyResponse> jList = mapper.readValue(resString,
					new TypeReference<List<SequenceInfoKeyResponse>>() {
					});
			/**
			 * If FA is requesting last live leg trade for a sequence which is created @sd
			 * through last live leg application(new) then restrict this trade.@sd
			 */
			if (jList.get(0).getAddCode() != null) {
				if (jList.get(0).getAddCode().equals("LL")) { // Is it having LL assignment?
					response.setStatus("Failed"); // We can not trade sequence which was created through trade
					response.setResponse("Can not trade last live leg again");
				}
			}

			// validate base
			final String base = jList.get(0).getBase();

			if (base.contains("EZE") || base.contains("BOG") || base.contains("SCL") || base.contains("LIM")) {
				System.out.println(":::::Invalid input data ::::::south american sequence");
				response.setStatus("Failed");
				response.setResponse("South American Sequence not applicable to trade");
			}

			final boolean legtype = jList.get(0).getInternational();

			if (legtype) {
				System.out.println(":::::Invalid input data ::::::International sequence");
				response.setStatus("Failed");
				response.setResponse("International sequence not applicable to trade");
			}

			// validate original employee
			final String origEmpId = Integer.toString(jList.get(0).getEmployeeID());
			if (!origEmpId.equalsIgnoreCase(sd.getFa1ID())) {
				// System.out.println("::::: orignal FA from ui " +sd.getFa1ID() +" not on given
				// sequence ::::"+origEmpId );
				response.setStatus("Failed");
				response.setResponse("Invalid Original FA - NOT FOUND ON SEQ/DATE ");
			}
			return jList;
		} else {

			System.out.println(":::::Invalid input data ::::::::::");
			response.setStatus(" Failed");
			response.setResponse("Invalid Input data - NOT FOUND SEQ/DATE ");
		}
		// } // end of try
		// catch (IOException e) {
		//
		// e.printStackTrace();
		//
		// }
		return null;
	}

	public static SequenceByKeysRequest getObjectData(final SequenceByKeysRequest req, final String contractualMon,
			final SequenceDetailsEntity sd) {
		// Insert the data
		req.setIncludeDutyPeriods(true);
		req.setGets(Arrays.asList("ALL"));

		final List<com.aa.entities.ccsRequest.SequenceInfoKey> seqInfoKeys = new ArrayList<>();
		req.setSequenceInfoKeys(seqInfoKeys);
		final com.aa.entities.ccsRequest.SequenceInfoKey seqInfoKey = new com.aa.entities.ccsRequest.SequenceInfoKey();
		seqInfoKeys.add(seqInfoKey);
		seqInfoKey.setAirlineCode("AA");
		seqInfoKey.setContractMonth(contractualMon);
		seqInfoKey.setOriginationDate(sd.getSeqOrigDate());
		seqInfoKey.setPosition(sd.getPosition());
		seqInfoKey.setSequenceNumber(sd.getSequenceNum());
		// Return the object.
		return req;
	}

	/* getLastIndexInfo developed by Sivan */
	
	/**
	 * 
	 * @author skumar
	 * @param jList
	 * @return getLastIndexInfo
	 * @throws NoSuchFieldException
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws ParseException
	 */
	public int getLastIndexInfo(final List<SequenceInfoKeyResponse> jList)
			throws NoSuchFieldException, IOException, KeyManagementException, UnrecoverableKeyException,
			NoSuchAlgorithmException, KeyStoreException, CertificateException, ParseException {
		int legindex;
		{
			/***************************
			 * start the validation
			 *******************************************************/
			final List<String> list1 = new ArrayList<String>();
			final int index = 0;
			final FlightLegs flightlegs = new FlightLegs();
			final FlightLegs flightlegs2 = new FlightLegs();
			final ArrayList<LegItem> items = new ArrayList<LegItem>();
			final ArrayList<LegItem> items2 = new ArrayList<LegItem>();
			int DPIndex = 0;
			int CurrentDP = 0;
			int currnetDP2 = 0;
			boolean completedleg = false;

			final boolean lleg = false;

			for (final SequenceInfoKeyResponse keyResponse : jList) {
				for (final FlightDutyPeriodDTO flightdutyPeriodDTO : keyResponse.getFlightDutyPeriods()) {
					for (final FlightLegDTO flightLegDTO : flightdutyPeriodDTO.getFlightLegs()) {
						/*                                                                */
						/** find active leg or not *****************************************/
						/*                                                                */
						final Actual actual = flightLegDTO.getActual();
						if (flightLegDTO.getLegStatuses().contains("ACTIVE")) {
							try {
								final String depgmt = actual.getDepartureDateTime().getGmt();
								final LocalDateTime time1 = LocalDateTime.parse(depgmt);
								final LocalDateTime time2 = LocalDateTime.now(ZoneOffset.UTC);
								if (time1.isAfter(time2)) {
									System.out.println("actual time is in future");
									list1.add("ACTIVE");
								} else {
									System.out.println("actual time is in past");
									list1.add("INACTIVE");
									completedleg = true;
								}
							} catch (final NullPointerException e) {
								list1.add("ACTIVE"); // if flow coming here,it must be having
														// SKD/RSK
								if ((flightLegDTO.getLegStatuses().contains("SURFACE")) ||       //@TK SURFACE LEG
								   (flightLegDTO.getLegStatuses().contains("TRAINING")) ||        //@Training leg
								    (flightLegDTO.getLegStatuses().contains("OAL_DEADHEAD"))) {   //@TK OAL DEAD HEAD LEG
									final Scheduled SCH = flightLegDTO.getScheduled();
									final String depgmt = SCH.getDepartureDateTime().getGmt();
									final LocalDateTime time1 = LocalDateTime.parse(depgmt);
									final LocalDateTime time2 = LocalDateTime.now(ZoneOffset.UTC);
									if (time1.isBefore(time2)) {
     									System.out.println("scheduled time is in past");
     									if (list1 != null && !list1.isEmpty()) {
										list1.remove(list1.size()-1);
     									}
										list1.add("INACTIVE");
									}
								}
									
							}
							//-----------------------------------------------------------------------------------------------//
							
							if (list1.get(list1.size() - 1) == "ACTIVE") {
								CurrentDP = flightdutyPeriodDTO.getDutyPeriodNumber(); // DP number
								if (CurrentDP != currnetDP2) {
									currnetDP2 = CurrentDP;
									DPIndex = DPIndex + 1;
								}
								final LegItem RLI = build_flight_details(flightLegDTO, DPIndex); // build
								// flight
								// details
								items.add(RLI);

								final LegItem RLI2 = build_flight_details2(flightLegDTO, DPIndex); // build
								// flight
								// details
								items2.add(RLI2);
							}
						} else {
							list1.add("INACTIVE");
						}
						/*                                                                */
						/*-------------------find type of leg--------------------------------------------------------*/
						if (flightLegDTO.getLegStatuses().contains("SURFACE")) {
							list1.add("SURFACE");

						} else if (flightLegDTO.getLegStatuses().contains("SHORT_DP")) {
							list1.add("SHORT_DP");

						} else if (flightLegDTO.getLegStatuses().contains("REMOVED")) {
							list1.add("REMOVED");

						} else if (flightLegDTO.getLegStatuses().contains("CANCELLED")) {
							list1.add("CANCELLED");

						} else if (flightLegDTO.getLegStatuses().contains("TRAINING")) {
							list1.add("TRAINING");

						} else if (flightLegDTO.getLegStatuses().contains("DEADHEAD")) {
							list1.add("DEADHEAD");

						} else {
							list1.add("NORMAL");
						}
						/*-------------------------------------------------------------------------------------------*/
					}
				}
			}

			flightlegs.setItems(items);
			setFlightlegs(flightlegs);

			flightlegs2.setItems(items2);
			setFlightlegs2(flightlegs2);

			/*** loop through all slots in the list **********/
			System.out.println("list: " + list1);
			boolean liveleg = false;
			final boolean trade = false;
			boolean activelegs = false;
			int i = 0;
			legindex = 99;
			boolean non_aplicable_dhd = false;

			for (i = list1.size() - 1; i >= 0; i = i - 2) {

				if ((list1.get(i - 1) == "ACTIVE") && (list1.get(i) != "DEADHEAD") && (list1.get(i) != "NORMAL")) {
					non_aplicable_dhd = true;
					liveleg = false;
					break;
				}
				/*** if found normal active leg, update liveleg variable *********************/
				if ((list1.get(i) == "NORMAL") && (list1.get(i - 1) == "ACTIVE") && (!liveleg)) {
					legindex = i;
					liveleg = true;
					continue;
				}
				/*** check any previous leg active other than last live leg ******************/
				if ((liveleg) && (list1.get(i - 1) == "ACTIVE")) {
					activelegs = true;
					break;
				}
			}
			/**********************************************/
			if ((liveleg) && (!activelegs) && (!non_aplicable_dhd)) {
				legindex = (legindex + 1) / 2;
				System.out.print("eligible sequence to trade and leg index is " + legindex);
			} else {
				System.out.println("no eligibility to trade");
				legindex = 99;
				// System.out.println("leg index while setting 99 is "+legindex );
			}
		}
		return legindex;
	}

	/**
	 * @author skumar
	 * @param flightLegDTO
	 * @param DPIndex
	 * @return LegItem
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchFieldException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws ParseException
	 * @throws IOException
	 */
	public LegItem build_flight_details(final FlightLegDTO flightLegDTO, final int DPIndex)
			throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException, NoSuchAlgorithmException,
			KeyStoreException, CertificateException, ParseException, IOException {

		final LegItem LI = new LegItem();
		final FlightKey FK = new FlightKey();
		final Actual actual = flightLegDTO.getActual();
		final ReScheduled RSK = flightLegDTO.getReScheduled();
		final Scheduled scheduled = flightLegDTO.getScheduled();
		final EquipmentQuals equipmentQuals = flightLegDTO.getEquipmentQuals();
		final DepartureDateTime CDDT = scheduled.getDepartureDateTime();
		// if reschedule or actual exist, use it's arrival time.
		final ArrivalDateTime CADT = scheduled.getArrivalDateTime();
		// populate Flight keys data from CCS entity
		FK.setAirlineCode(flightLegDTO.getAirlineCode());
		FK.setDepartureAirport(flightLegDTO.getDepartureStation());
		FK.setDepartureStationDupe(flightLegDTO.getDepartureDuplicateCode());
		FK.setFlightNumber(String.valueOf(flightLegDTO.getFlightNumber()));
		FK.setFlightOriginationDate(flightLegDTO.getFlightOriginationDate());
		FK.setLegIndex(flightLegDTO.getLegIndex());
		// populate LegItem data from CCS entity
		LI.setFlightKey(FK);
		LI.setArrivalAirport(flightLegDTO.getArrivalStation());
		LI.setBlockTime(flightLegDTO.getBlockTime());
		// OAL leg details
		LI.setOalSurfaceAirline("");
		// Leg type
		LI.setDeadHead(false);
		if (flightLegDTO.getLegStatuses().contains("DEADHEAD")) {
			LI.setDeadHead(true);
			if (flightLegDTO.getLegStatuses().contains("OAL_DEADHEAD")) {
				LI.setOalSurfaceAirline(flightLegDTO.getDeadHeadAirlineCode());
			}
		}
		final ResponseEntity response = new ResponseEntity();
		// populate misc. details
		final String con_date = ccs.get_contractual_month(flightLegDTO.getFlightOriginationDate(), response);
		LI.setContractMonth(con_date);
		LI.setDutyPeriod(DPIndex);
		LI.setInternational(false);
		LI.setLanguageQuals(null);
		// Flight Equipment Details ----------------------------------------------------
		LI.setEquipmentGroup(equipmentQuals.getEquipmentGroup());
		LI.setEquipmentType(equipmentQuals.getEquipmentType());
		// Leg status
		final FlightLegStatusProperties FLP = new FlightLegStatusProperties();
		FLP.setaCTIVE(true);
		LI.setFlightLegStatusProperties(FLP);
		// update visa details
		LI.setVisaCountry(flightLegDTO.getVisaCountry());
		LI.setVisaIndicator(flightLegDTO.getVisaIndicator());
		// Departure time
		final Scheduled2 SKD1 = new Scheduled2();
		SKD1.setBaseTime(CDDT.getBaseTime());
		SKD1.setGmt(CDDT.getGmt());
		SKD1.setLocalTime(CDDT.getLocalTime());
		final DepartureTime DT = new DepartureTime();
		DT.setScheduled(SKD1);
		LI.setDepartureTime(DT);
		// update OAL departuredatetime
		final OalDepartureDateTime OAL_dep = new OalDepartureDateTime();
		OAL_dep.setBaseTime(CDDT.getBaseTime());
		OAL_dep.setGmt(CDDT.getGmt());
		OAL_dep.setLocalTime(CDDT.getLocalTime());
		LI.setOalDepartureDateTime(OAL_dep);
		// Arrival time
		final Scheduled2 SKD2 = new Scheduled2();
		SKD2.setBaseTime(CADT.getBaseTime());
		SKD2.setGmt(CADT.getGmt());
		SKD2.setLocalTime(CADT.getLocalTime());
		final ArrivalTime AT = new ArrivalTime();
		AT.setScheduled(SKD2);
		LI.setArrivalTime(AT);
		// OAL arrival date/time
		final OalArrivalDateTime OALarr = new OalArrivalDateTime();
		OALarr.setBaseTime(CADT.getBaseTime());
		OALarr.setGmt(CADT.getGmt());
		OALarr.setLocalTime(CADT.getLocalTime());
		LI.setOalArrivalDateTime(OALarr);
		return LI;
	}

	/**************************
	 * build data for QLA
	 ***************************************/

	public LegItem build_flight_details2(final FlightLegDTO flightLegDTO, final int DPIndex)
			throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException, NoSuchAlgorithmException,
			KeyStoreException, CertificateException, ParseException, IOException {
		final LegItem LI2 = new LegItem();
		final FlightKey FK = new FlightKey();
		final Actual actual = flightLegDTO.getActual();
		final ReScheduled RSK = flightLegDTO.getReScheduled();
		final Scheduled scheduled = flightLegDTO.getScheduled();
		final EquipmentQuals equipmentQuals = flightLegDTO.getEquipmentQuals();
		// update departure date and time
		DepartureDateTime CDDT = new DepartureDateTime();
                //check actual -> reschedule -> schedule timing 
		try	{
			if (!actual.getDepartureDateTime().getGmt().isEmpty()){
				CDDT = actual.getDepartureDateTime(); }
		} catch (NullPointerException e1) {
			try {
			    if (!RSK.getDepartureDateTime().getGmt().isEmpty()) {
					CDDT = RSK.getDepartureDateTime();
			    } } catch (NullPointerException e2) {
				CDDT = scheduled.getDepartureDateTime();
			}
		}
		// if reschedule or actual exist, use it's arrival time.
		ArrivalDateTime CADT = new ArrivalDateTime();
		try {
			if (!actual.getArrivalDateTime().getGmt().isEmpty()) {
				CADT = actual.getArrivalDateTime();
			}} catch (NullPointerException e1) {
			try {
			if (!RSK.getArrivalDateTime().getGmt().isEmpty()) {
				CADT = RSK.getArrivalDateTime();
			}} catch (NullPointerException e2) {
			CADT = scheduled.getArrivalDateTime();
		     }
		}
		// populate Flight keys data from CCS entity
		FK.setAirlineCode(flightLegDTO.getAirlineCode());
		FK.setDepartureAirport(flightLegDTO.getDepartureStation());
		FK.setDepartureStationDupe(flightLegDTO.getDepartureDuplicateCode());
		FK.setFlightNumber(String.valueOf(flightLegDTO.getFlightNumber()));
		FK.setFlightOriginationDate(flightLegDTO.getFlightOriginationDate());
		FK.setLegIndex(flightLegDTO.getLegIndex());
		// populate LegItem data from CCS entity
		LI2.setFlightKey(FK);
		LI2.setArrivalAirport(flightLegDTO.getArrivalStation());
		LI2.setBlockTime(flightLegDTO.getBlockTime());
		// OAL leg details
		LI2.setOalSurfaceAirline("");
		// Leg type
		LI2.setDeadHead(false);
		if (flightLegDTO.getLegStatuses().contains("DEADHEAD")) {
			LI2.setDeadHead(true);
			if (flightLegDTO.getLegStatuses().contains("OAL_DEADHEAD")) {
				LI2.setOalSurfaceAirline(flightLegDTO.getDeadHeadAirlineCode());
			}
		}
		// populate -----------------------------------

		final ResponseEntity response = new ResponseEntity();
		final String con_date = ccs.get_contractual_month(flightLegDTO.getFlightOriginationDate(), response);
		LI2.setContractMonth(con_date);
		LI2.setDutyPeriod(DPIndex);
		LI2.setInternational(false);
		LI2.setLanguageQuals(null);
		// Flight Equipment Details ----------------------------------------------------
		LI2.setEquipmentGroup(equipmentQuals.getEquipmentGroup());
		LI2.setEquipmentType(equipmentQuals.getEquipmentType());
		// Leg status
		final FlightLegStatusProperties FLP = new FlightLegStatusProperties();
		FLP.setaCTIVE(true);
		LI2.setFlightLegStatusProperties(FLP);
		// visa details
		LI2.setVisaCountry(flightLegDTO.getVisaCountry());
		LI2.setVisaIndicator(flightLegDTO.getVisaIndicator());
		// Departure time
		final Scheduled2 SKD1 = new Scheduled2();
		SKD1.setBaseTime(CDDT.getBaseTime());
		SKD1.setGmt(CDDT.getGmt());
		SKD1.setLocalTime(CDDT.getLocalTime());
		final DepartureTime DT = new DepartureTime();
		DT.setScheduled(SKD1);
		LI2.setDepartureTime(DT);
		// update OAL departuredatetime
		final OalDepartureDateTime OAL_dep = new OalDepartureDateTime();
		OAL_dep.setBaseTime(CDDT.getBaseTime());
		OAL_dep.setGmt(CDDT.getGmt());
		OAL_dep.setLocalTime(CDDT.getLocalTime());
		LI2.setOalDepartureDateTime(OAL_dep);
		// Arrival time
		final Scheduled2 SKD2 = new Scheduled2();
		SKD2.setBaseTime(CADT.getBaseTime());
		SKD2.setGmt(CADT.getGmt());
		SKD2.setLocalTime(CADT.getLocalTime());
		final ArrivalTime AT = new ArrivalTime();
		AT.setScheduled(SKD2);
		LI2.setArrivalTime(AT);
		// OAL arrival date/time
		final OalArrivalDateTime OALarr = new OalArrivalDateTime();
		OALarr.setBaseTime(CADT.getBaseTime());
		OALarr.setGmt(CADT.getGmt());
		OALarr.setLocalTime(CADT.getLocalTime());
		LI2.setOalArrivalDateTime(OALarr);
		return LI2;
	}

	public FlightLegs getFlightlegs() {
		return flightlegs;
	}

	public void setFlightlegs(final FlightLegs flightlegs) {
		this.flightlegs = flightlegs;
	}

	public FlightLegs getFlightlegs2() {
		return flightlegs2;
	}

	public void setFlightlegs2(final FlightLegs flightlegs2) {
		this.flightlegs2 = flightlegs2;
	}

}
