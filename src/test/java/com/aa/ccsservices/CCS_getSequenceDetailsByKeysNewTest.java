package com.aa.ccsservices;

//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


import com.aa.connection.CommonConnection;
import com.aa.entities.ResponseEntity;
import com.aa.entities.SequenceDetailsEntity;
import com.aa.entities.ccsResponse.SequenceInfoKeyResponse;

@RunWith(MockitoJUnitRunner.class)
public class CCS_getSequenceDetailsByKeysNewTest {

	@InjectMocks
	private CCS_getSequenceDetailsByKeysNew ccs;
	
	
	@Mock
	private CommonConnection commonconnection;
	
	@Test
	public List<SequenceInfoKeyResponse> get_seq_detailsTest() throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, KeyStoreException, IOException, NoSuchFieldException, ParseException {
		
		
		SequenceDetailsEntity sd = new SequenceDetailsEntity();
		ResponseEntity responseEntity = new ResponseEntity();
		String contractualMonth = "AUG2021";
		
		String resString = "[{\"airlineCode\":\"AA\",\"base\":\"DFW\",\"contractMonth\":\"AUG2021\",\"sequenceOriginDate\":\"2021-08-24\",\"sequenceNumber\":31576,\"positionCode\":\"01\",\"division\":\"D\",\"employeeID\":805980,\"durationInDays\":2,\"sequenceStartDateTime\":{\"localTime\":\"2021-08-24T22:26:00\",\"gmt\":\"2021-08-25T03:26:00\",\"baseTime\":\"2021-08-24T22:26:00\"},\"sequenceEndDateTime\":{\"localTime\":\"2021-08-25T17:57:00\",\"gmt\":\"2021-08-25T22:57:00\",\"baseTime\":\"2021-08-25T17:57:00\"},\"legsPerDutyPeriod\":\"2-2\",\"numberOfLegs\":4,\"firstLegDepartureTime\":{\"localTime\":\"2021-08-24T23:27:00\",\"gmt\":\"2021-08-25T04:27:00\",\"baseTime\":\"2021-08-24T23:27:00\"},\"firstLegDepartureAirport\":\"DFW\",\"layoverStations\":\"DFW-\",\"ronCities\":[\"DFW\"],\"landingQuals\":\"0000000000000000\",\"equipmentGroup\":\"737\",\"creditThisMonth\":600,\"creditNextMonth\":0,\"scheduledFlight\":207,\"positionSequenceInfo1\":\"42\",\"positionSequenceInfo1Binary\":\"01000010\",\"positionSequenceInfo2\":\"00\",\"addCode\":\"25\",\"assignedStandbyShift\":false,\"awardedStandbyShift\":false,\"lastSequencePayProtection\":false,\"flightDutyPeriods\":[{\"startDateTime\":{\"localTime\":\"2021-08-24T22:26:00\",\"gmt\":\"2021-08-25T03:26:00\",\"baseTime\":\"2021-08-24T22:26:00\"},\"dutyPeriodNumber\":1,\"endDateTime\":{\"localTime\":\"2021-08-25T03:03:00\",\"gmt\":\"2021-08-25T08:03:00\",\"baseTime\":\"2021-08-25T03:03:00\"},\"odMinutes\":263,\"numberOfLegs\":2,\"layOverAirport\":\"DFW\",\"duration\":69,\"layoverInMinutes\":631,\"flightLegs\":[{\"airlineCode\":\"AA\",\"legType\":\"00000000100100000000000000000000\",\"legStatuses\":[\"START_OF_DP\",\"ACTIVE\"],\"flightNumber\":12,\"legIndex\":1,\"departureStation\":\"DFW\",\"flightOriginationDate\":\"2021-08-24\",\"visaIndicator\":\"A0\",\"equipmentQuals\":{\"equipmentNumber\":\"25\",\"equipmentGroup\":\"737\",\"equipmentType\":\"738M\"},\"blockTime\":92,\"groundTime\":27,\"deadHead\":false,\"scheduled\":{\"departureDateTime\":{\"localTime\":\"2021-08-24T23:26:00\",\"gmt\":\"2021-08-25T04:26:00\",\"baseTime\":\"2021-08-24T23:26:00\"},\"arrivalDateTime\":{\"localTime\":\"2021-08-25T00:35:00\",\"gmt\":\"2021-08-25T05:35:00\",\"baseTime\":\"2021-08-25T00:35:00\"}},\"actual\":{\"departureDateTime\":{\"localTime\":\"2021-08-24T23:27:00\",\"gmt\":\"2021-08-25T04:27:00\",\"baseTime\":\"2021-08-24T23:27:00\"},\"arrivalDateTime\":{\"localTime\":\"2021-08-25T00:59:00\",\"gmt\":\"2021-08-25T05:59:00\",\"baseTime\":\"2021-08-25T00:59:00\"}},\"delayMinutes\":{\"atcDelays\":0,\"deicingDelays\":0,\"rampDelays\":0},\"arrivalStation\":\"AUS\",\"departureDuplicateCode\":0,\"arrivalDuplicateCode\":0,\"noShowDHD\":false,\"active\":true,\"cancelled\":false,\"removed\":false,\"greaterTime\":92,\"diversionTime\":0,\"actualSeat\":\"01\",\"signedIn\":false,\"isIPD\":false,\"endOfDutyPeriod\":false,\"endOfSequence\":false,\"international\":false,\"startOfDutyPeriod\":true,\"posLangPremPay\":false},{\"airlineCode\":\"AA\",\"legType\":\"00000000010100000100001100000000\",\"legStatuses\":[\"END_OF_DP\",\"ACTIVE\",\"DEADHEAD\",\"DEADHEAD_BOARDING\"],\"flightNumber\":18,\"legIndex\":2,\"departureStation\":\"AUS\",\"flightOriginationDate\":\"2021-08-25\",\"visaIndicator\":\"A0\",\"equipmentQuals\":{\"equipmentNumber\":\"25\",\"equipmentGroup\":\"737\",\"equipmentType\":\"738M\"},\"blockTime\":82,\"groundTime\":0,\"deadHead\":true,\"scheduled\":{\"departureDateTime\":{\"localTime\":\"2021-08-25T01:25:00\",\"gmt\":\"2021-08-25T06:25:00\",\"baseTime\":\"2021-08-25T01:25:00\"},\"arrivalDateTime\":{\"localTime\":\"2021-08-25T02:34:00\",\"gmt\":\"2021-08-25T07:34:00\",\"baseTime\":\"2021-08-25T02:34:00\"}},\"actual\":{\"departureDateTime\":{\"localTime\":\"2021-08-25T01:26:00\",\"gmt\":\"2021-08-25T06:26:00\",\"baseTime\":\"2021-08-25T01:26:00\"},\"arrivalDateTime\":{\"localTime\":\"2021-08-25T02:48:00\",\"gmt\":\"2021-08-25T07:48:00\",\"baseTime\":\"2021-08-25T02:48:00\"}},\"delayMinutes\":{\"atcDelays\":0,\"deicingDelays\":0,\"rampDelays\":0},\"arrivalStation\":\"DFW\",\"departureDuplicateCode\":0,\"arrivalDuplicateCode\":0,\"noShowDHD\":false,\"active\":true,\"cancelled\":false,\"removed\":false,\"greaterTime\":82,\"diversionTime\":0,\"actualSeat\":\"01\",\"signedIn\":false,\"isIPD\":false,\"endOfDutyPeriod\":true,\"endOfSequence\":false,\"legAssignmentCode\":\"25\",\"international\":false,\"startOfDutyPeriod\":false,\"posLangPremPay\":false}],\"payCredit\":{\"greaterTime\":92,\"scheduledBlockTime\":69,\"actualBlockTime\":92,\"scheduledTotalCredit\":216,\"actualTotalCredit\":180,\"deadheadCredit\":82,\"scheduledRig\":124,\"actualRig\":88},\"dutyPeriodStatus\":\"COMPLETED\",\"odan\":false,\"redEye\":true,\"hawaiiDutyPeriod\":false,\"mediumRangeDP\":false,\"nonLongRangeDP\":false,\"domesticDP\":false,\"ipdDP\":false,\"fdpDuration\":0,\"fdpAcclimatedStnTZAdjustment\":0},{\"startDateTime\":{\"localTime\":\"2021-08-25T13:34:00\",\"gmt\":\"2021-08-25T18:34:00\",\"baseTime\":\"2021-08-25T13:34:00\"},\"dutyPeriodNumber\":2,\"endDateTime\":{\"localTime\":\"2021-08-25T17:57:00\",\"gmt\":\"2021-08-25T22:57:00\",\"baseTime\":\"2021-08-25T17:57:00\"},\"odMinutes\":263,\"numberOfLegs\":2,\"duration\":138,\"layoverInMinutes\":0,\"flightLegs\":[{\"airlineCode\":\"AA\",\"legType\":\"00000000100100000000000000000000\",\"legStatuses\":[\"START_OF_DP\",\"ACTIVE\"],\"flightNumber\":19,\"legIndex\":3,\"departureStation\":\"DFW\",\"flightOriginationDate\":\"2021-08-25\",\"visaIndicator\":\"A0\",\"equipmentQuals\":{\"equipmentNumber\":\"25\",\"equipmentGroup\":\"737\",\"equipmentType\":\"738M\"},\"blockTime\":69,\"groundTime\":50,\"deadHead\":false,\"scheduled\":{\"departureDateTime\":{\"localTime\":\"2021-08-25T14:34:00\",\"gmt\":\"2021-08-25T19:34:00\",\"baseTime\":\"2021-08-25T14:34:00\"},\"arrivalDateTime\":{\"localTime\":\"2021-08-25T15:43:00\",\"gmt\":\"2021-08-25T20:43:00\",\"baseTime\":\"2021-08-25T15:43:00\"}},\"delayMinutes\":{\"atcDelays\":0,\"deicingDelays\":0,\"rampDelays\":0},\"arrivalStation\":\"AUS\",\"departureDuplicateCode\":0,\"arrivalDuplicateCode\":0,\"noShowDHD\":false,\"active\":true,\"cancelled\":false,\"removed\":false,\"greaterTime\":69,\"diversionTime\":0,\"actualSeat\":\"01\",\"signedIn\":false,\"isIPD\":false,\"endOfDutyPeriod\":false,\"endOfSequence\":false,\"international\":false,\"startOfDutyPeriod\":true,\"posLangPremPay\":false},{\"airlineCode\":\"AA\",\"legType\":\"00000000011100000000000000000000\",\"legStatuses\":[\"END_OF_DP\",\"END_OF_SEQ\",\"ACTIVE\"],\"flightNumber\":20,\"legIndex\":4,\"departureStation\":\"AUS\",\"flightOriginationDate\":\"2021-08-25\",\"visaIndicator\":\"A0\",\"equipmentQuals\":{\"equipmentNumber\":\"25\",\"equipmentGroup\":\"737\",\"equipmentType\":\"738M\"},\"blockTime\":69,\"groundTime\":0,\"deadHead\":false,\"scheduled\":{\"departureDateTime\":{\"localTime\":\"2021-08-25T16:33:00\",\"gmt\":\"2021-08-25T21:33:00\",\"baseTime\":\"2021-08-25T16:33:00\"},\"arrivalDateTime\":{\"localTime\":\"2021-08-25T17:42:00\",\"gmt\":\"2021-08-25T22:42:00\",\"baseTime\":\"2021-08-25T17:42:00\"}},\"delayMinutes\":{\"atcDelays\":0,\"deicingDelays\":0,\"rampDelays\":0},\"arrivalStation\":\"DFW\",\"departureDuplicateCode\":0,\"arrivalDuplicateCode\":0,\"noShowDHD\":false,\"active\":true,\"cancelled\":false,\"removed\":false,\"greaterTime\":69,\"diversionTime\":0,\"actualSeat\":\"01\",\"signedIn\":false,\"isIPD\":false,\"endOfDutyPeriod\":true,\"endOfSequence\":true,\"international\":false,\"startOfDutyPeriod\":false,\"posLangPremPay\":false}],\"payCredit\":{\"greaterTime\":138,\"scheduledBlockTime\":138,\"actualBlockTime\":0,\"scheduledTotalCredit\":420,\"actualTotalCredit\":420,\"deadheadCredit\":0,\"scheduledRig\":282,\"actualRig\":282},\"dutyPeriodStatus\":\"SCHEDULED\",\"odan\":false,\"redEye\":false,\"hawaiiDutyPeriod\":false,\"mediumRangeDP\":false,\"nonLongRangeDP\":false,\"domesticDP\":false,\"ipdDP\":false,\"fdpDuration\":0,\"fdpAcclimatedStnTZAdjustment\":0}],\"speakerRequirement\":{\"posSpeakerRestricted\":false,\"totalRequiredForSeq\":0,\"totalMissingForSeq\":0,\"totalRequiredForCabin\":0,\"totalMissingForCabin\":0,\"nonCabinSpecific\":false},\"failsContinuity\":false,\"galleyPosition\":false,\"totalLegCount\":0,\"sequencePayCredit\":{\"greaterTime\":230,\"scheduledBlockTime\":207,\"actualBlockTime\":92,\"scheduledTotalCredit\":636,\"actualTotalCredit\":600,\"deadheadCredit\":82,\"scheduledRig\":406,\"actualRig\":370,\"payProtectedValue\":0,\"totalSequenceCredit\":600},\"sequenceBlockTime\":0,\"sequencePayTime\":0,\"international\":false,\"timeAwayFromBase\":1171,\"isSatellite\":false,\"isCoterminal\":false,\"isIPD\":false,\"isNIPD\":false,\"isODAN\":false,\"isRedEye\":true,\"isRedFlag\":false,\"isTrainingSequence\":false,\"firstLegDeadHeadIndicator\":false,\"lastLegDeadHeadIndicator\":false,\"lastLegArrivalAirport\":\"DFW\",\"lastLegArrivalTime\":{\"localTime\":\"2021-08-25T17:42:00\",\"gmt\":\"2021-08-25T22:42:00\",\"baseTime\":\"2021-08-25T17:42:00\"},\"totalOpenPositionsForSeq\":0,\"totalOpenPositionsForCabin\":0,\"multipleEquipments\":false,\"noShowDHD\":false,\"observationTrip\":false,\"ttInhibited\":false,\"purser\":false,\"notQualified\":false,\"signedIn\":false,\"sequenceStatus\":\"IN_PROGRESS\",\"serviceQualsHex\":\"0000\",\"deleted\":false,\"isBlockedforIOE\":false,\"isSuperNumerary\":false,\"premiumInd\":0,\"reassignmentNumber\":0,\"hbtsequence\":false}]\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "";
		
		when(commonconnection.json_response(eq("CCS"), eq(null), any(), eq(responseEntity)))
		.thenReturn(resString);
		
		sd.setFa1ID("752848");
		sd.setSequenceNum("31549");
		sd.setFa2ID("562320S");
		sd.setSeqOrigDate("2021-08-17");
		sd.setPosition("01");
		
		List<SequenceInfoKeyResponse> jList = ccs.get_Seq_details(sd, responseEntity, contractualMonth);
		
		System.out.println(jList);
		
		assertNotNull(jList);
		
		return jList;
	}

}
