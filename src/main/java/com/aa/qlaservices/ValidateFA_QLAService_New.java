/**
 * Developed by Uma on 12-Mar-2021
 * This file has business functions to execute validate FA QLA service
 */

package com.aa.qlaservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aa.connection.CommonConnection;
import com.aa.crew.apigee.AccessTokenClientImpl;
import com.aa.entities.ResponseEntity;
import com.aa.entities.qlarequest.QLARequestPayload;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ValidateFA_QLAService_New {

//    @Autowired
//    private AccessTokenClientImpl accesstoken;

    @Autowired
    private CommonConnection commonconnection;

    @Value("${tdec.QLAValidateFA_EndPoint}")
    private String service_name;

    public String validate_FA_QLA_Service(final QLARequestPayload qlaRequest)
            throws NoSuchFieldException, ParseException, KeyManagementException, UnrecoverableKeyException,
            KeyStoreException, NoSuchAlgorithmException, CertificateException {

        String responseStr = null;

        try {
            final ObjectMapper Obj = new ObjectMapper();
            final String jsonStr = Obj.writeValueAsString(qlaRequest);

            // Convert to JSON String
            System.out.println("QLA JSON SEQ info by key :" + jsonStr);
            final JSONParser parser = new JSONParser();
            final JSONObject json = (JSONObject) parser.parse(jsonStr);

            final ResponseEntity response = new ResponseEntity();
            final String server_name = "QLA";
            responseStr = commonconnection.json_response(server_name, service_name, json, response);

            System.out.println(responseStr);
            return responseStr;

        } catch (final IOException e) {
            e.printStackTrace();

        }
        return responseStr;
    }

}
