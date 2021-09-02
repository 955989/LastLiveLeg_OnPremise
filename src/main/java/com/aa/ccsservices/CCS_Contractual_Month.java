/**
 *
 *@author skumar
 *Get contract month from CCS service
 */
package com.aa.ccsservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aa.connection.CommonConnection;
import com.aa.entities.ResponseEntity;
import com.aa.entities.ccsResponse.ContractualMonthResponseEntity;

@Service

// @PropertySource(value = { "application.properties" })
// @PropertySource(value = {"classpath:application.properties"},
// ignoreResourceNotFound = true)
public class CCS_Contractual_Month {

    // @Autowired
    // private AccessTokenClientImpl accesstoken;

    @Autowired
    private CommonConnection commonconnection;

    @Value("${tdec.CCS_EndPoint}")
    private String service_name;

    /**
     * Get contractual month from the CCS service
     *
     * @author 
     * @param date,
     *            response
     * @return contract month in String format
     * @throws NoSuchFieldException
     * @throws ParseException
     * @throws KeyManagementException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws IOException
     */
    public String get_contractual_month(final String date, final ResponseEntity response)
            throws NoSuchFieldException, ParseException, KeyManagementException, UnrecoverableKeyException,
            NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {

        String contractualMonth = "";
        System.out.println("CCS APIGEE Token call...");

        System.out.println("Connecting to CCS Service");

        final JSONObject json = new JSONObject();
        json.put("airlineCode", "AA");
        json.put("date", date);

        final String server_name = "CCS";

        final String resString = commonconnection.json_response(server_name, service_name, json, response);
        /*******
         * Convert JASON String to JAVA Object entity
         *****************************/
        try {

            /******* Convert JASON String to JAVA Object entity *****************************/
            if (resString != null) {
                final ObjectMapper mapper = new ObjectMapper();
                final ContractualMonthResponseEntity responseEntity = mapper.readValue(resString,
                    ContractualMonthResponseEntity.class);
                contractualMonth = responseEntity.getContractMonth();
            }

        } // end of try
        catch (final IOException e) {
            e.printStackTrace();
        }

        return contractualMonth;
    }

   

}
