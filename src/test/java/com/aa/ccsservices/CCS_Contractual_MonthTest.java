package com.aa.ccsservices;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.aa.connection.CommonConnection;
import com.aa.entities.ResponseEntity;
import com.aa.entities.ccsResponse.ContractualMonthResponseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class CCS_Contractual_MonthTest {

    @InjectMocks
    private CCS_Contractual_Month ccs_contractual_month;

    @Mock
    private CommonConnection commonconnection;

    @Test
    public String get_contractual_monthTest() throws Exception {
        final ResponseEntity responseEntity = new ResponseEntity();

        System.out.println("Inside method");

        when(commonconnection.json_response(eq("CCS"), eq(null), any(), eq(responseEntity)))
            .thenReturn("{\"airlineCode\":\"AA\",\"contractMonth\":\"AUG2021\",\"type\":null,\"startDate\":null,\"endDate\":null}");

        final String contractual_month = ccs_contractual_month.get_contractual_month("2021-08-15", responseEntity);

        assertEquals(contractual_month, "AUG2021");
        
        return contractual_month;
    }

//    @Test
//    public void outputTest() throws JsonProcessingException {
//        final ContractualMonthResponseEntity entity = new ContractualMonthResponseEntity();
//        entity.setAirlineCode("AA");
//        entity.setContractMonth("AUG2021");
//        final ObjectMapper mapper = new ObjectMapper();
//        final String string = mapper.writeValueAsString(entity);
//        System.out.println(string);
//    }
}
