/**
 *
 * @author skumar
 *Get crew member details from CCS service
 */

package com.aa.ccsservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
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

@Service
//@PropertySource(value = { "token.properties", "application.properties" })
public class CCS_getCrewMember {

    @Autowired
    private CommonConnection commonconnection;

    @Autowired
    private CCS_Contractual_Month ccs;

    @Value("${tdec.CCS_EndPoint_CrewDetails}")
    private String service_name;

    /**
     * Get employee details like base, position. Function will be enhanced in future
     *
     * @author rswami
     * @param sd
     * @param response
     * @param contractualMon
     * @return FA Base. Function will be enhanced to return multiple infor of FA
     * @throws NoSuchFieldException
     * @throws ParseException
     * @throws KeyManagementException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws IOException
     */
    public String get_emp_details(final SequenceDetailsEntity sd, final ResponseEntity response, String contractualMon)
            throws NoSuchFieldException, ParseException, KeyManagementException, UnrecoverableKeyException,
            NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {

        String replacementFABase = "";
        System.out.println("Connecting to CCS Service");
        contractualMon = ccs.get_contractual_month(sd.getSeqOrigDate(), response);
        replacementFABase = call_CCS_Service_ToGetBase(sd, contractualMon, response);
        return replacementFABase;

    }

    public String call_CCS_Service_ToGetBase(final SequenceDetailsEntity sd, final String contractualMon, final ResponseEntity response)
            throws NoSuchFieldException, IOException, KeyManagementException, UnrecoverableKeyException,
            NoSuchAlgorithmException, KeyStoreException, CertificateException, ParseException {

        /****
         * Build JASON OBJECT to Get contractual month for the given Date
         *************/

        String base = null;
        final JSONObject json = new JSONObject();
        final JSONArray arr = new JSONArray();

        arr.put("ALL");
        json.put("gets", arr);
        final JSONArray conMon = new JSONArray();
        conMon.put(contractualMon);
        json.put("contractMonths", conMon);

        final JSONObject arrSeqInfo = new JSONObject();
        final JSONObject arr1 = new JSONObject();
        arrSeqInfo.put("airlineCode", "AA");
        arrSeqInfo.put("employeeNumber", sd.getFa2ID());
        json.put("crewMemberKeyDTO", arrSeqInfo);

        final StringEntity params = new StringEntity(json.toString());

        System.out.println("CCS emp details req :" + json);

        final String server_name = "CCS";

        final String resString = commonconnection.json_response(server_name, service_name, json, response);
        System.out.println("CCS emp details resp :" + resString);
        if (resString == null) {
            System.out.println("  INVALID Replacement FA :");
            response.setStatus("Failed");
            response.setResponse("Invalid Replacement FA");

        } else {
            System.out.println(" Replacement FA BASE ");

            final JSONParser jsonParser = new JSONParser();
            final JSONObject repObj = (JSONObject) jsonParser.parse(resString);
            final org.json.simple.JSONArray data = (org.json.simple.JSONArray) repObj.get("bidStatuses");
            base = ((JSONObject) data.get(0)).get("currentBase").toString();
            System.out.println(" Replacement FA BASE " + base);
        }
        return base;
    }

}
