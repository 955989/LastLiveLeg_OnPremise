package com.aa.qlaservices;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.aa.ccsservices.CCS_getCrewMember;
import com.aa.connection.CommonConnection;
import com.aa.entities.ResponseEntity;
import com.aa.entities.SequenceDetailsEntity;
import com.aa.entities.qlarequest.DutyPeriods;
import com.aa.entities.qlarequest.FlightLegs;
import com.aa.entities.qlaresponse.QlaResponsePayload;

@RunWith(MockitoJUnitRunner.class)
public class QlaValidation_LegaityTest {

	@InjectMocks
	QlaEmpDataFromCCS qla;
	
	@Mock
    private QLA_Build_DutyPeriods buildDuty;

    @Mock
    private CommonConnection commonconnection;

    @Mock
    private CCS_getCrewMember ccsMem;
    
	@Test
	public List<QlaResponsePayload> map_CCS_QLA_EmpData(SequenceDetailsEntity sd, ResponseEntity response) throws KeyManagementException, UnrecoverableKeyException, NoSuchFieldException, NoSuchAlgorithmException, KeyStoreException, CertificateException, ParseException, IOException{
		
		
		FlightLegs FL = new FlightLegs();
		FL.getItems().get(0).getDepartureTime().getScheduled().setBaseTime("");
		FL.getItems().get(0).getDepartureTime().getScheduled().setGmt("");
		
		sd.setFa2ID("562370");
		sd.setPosition("01");
		
		String base = "DFW";
		
		when(ccsMem.get_emp_details(sd, response,any()))
			.thenReturn(base);
		
		
		DutyPeriods dutyPeriods = new DutyPeriods();
		dutyPeriods.getItems().get(0).getFlightDutyPeriodKey().setContractMonth("AUG");
		dutyPeriods.getItems().get(0).getFlightDutyPeriodKey().setOriginationDate("08-24-2021");
		
		when(buildDuty.build_DP(any(), sd.getPosition()))
		.thenReturn(dutyPeriods);
		
		
		String  resString = "";
		when(commonconnection.json_response(eq("QLA"), any(), any(), response))
		.thenReturn(resString);
		
		List<QlaResponsePayload> jList = qla.map_CCS_QLA_EmpData(null, sd, resString, null, response);
		return jList;
	}
	

}
