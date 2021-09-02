/**
 * @author sdabre
 * Connect to CCS / QLA service
 */
package com.aa.connection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.aa.crew.apigee.AccessTokenClientImpl;
import com.aa.entities.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
//@PropertySource(value = { "application.properties" })

public class CommonConnection {

    /***************************************************************************************************************/
    // This below code will read all token from token.properties file */

    private String ccs_token;

    private String qla_token;

    /* This will read data from application property file */

    @Value("${keyPassphrase}")
    private String keyPassphrase;

    @Value("${tdec.QLAValidateFA_EndPoint}")
    private String QLAEndpoint;

    @Value("${Environment}")
    private String Environment;

    @Autowired
    private Ccsconfig ccsconf;
    
    int cnt =1;

    /****************************************************************************************************************/

    public String json_response(final String server_name, final String service_name, final JSONObject json,
            final ResponseEntity responseEnt)
            throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException,
            KeyManagementException, UnrecoverableKeyException, KeyStoreException

    {

        final AccessTokenClientImpl tok = new AccessTokenClientImpl();
        ccs_token = tok.getCCS();
        qla_token = tok.getQLA();

        String resString = null;

        if (server_name.equalsIgnoreCase("CCS") || server_name.equalsIgnoreCase("OPSHUB"))

        {
            /*****************************************************************************************************/
            // Read certificate for CCS service and evaluate authenticity of request

            final SSLContext sslContext = SSLContextBuilder.create()
                .loadKeyMaterial(ResourceUtils.getFile(ccsconf.getCertificatePath()), keyPassphrase.toCharArray(),
                    keyPassphrase.toCharArray())
                .build();

            final HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
            /*****************************************************************************************************/
            // Read certificate for CCS service and evaluate authenticity of request

            final HttpPost post = new HttpPost(service_name);
            post.setHeader("Content-Type", "application/json;charset=UTF-8");
            post.setHeader("Authorization", "Bearer " + ccs_token);

            /*****************************************************************************************************/
            // Build request for CCS service

            final StringEntity params = new StringEntity(json.toString());
            post.setEntity(params);
            System.out.println(server_name + " Request:" + json);
            /*****************************************************************************************************/
            // send it to CCS Server and get response

            final HttpResponse response = httpClient.execute(post);

            // Convert HTTP entity response to JASON string format
            try {
                final HttpEntity resEntity = response.getEntity();

                if (resEntity != null) {

                    final StatusLine sl = response.getStatusLine();
                    final int statCode = sl.getStatusCode();
                    System.out.println("Status code from " + server_name + " ::: :" + statCode);

                    if (statCode == 200) {
                        resString = EntityUtils.toString(resEntity);
                        System.out.println(server_name + " Response :" + resString);
                        responseEnt.setStatus("Passed");
//                        responseEnt.setResponse("");
                    } else {
                        responseEnt.setStatus("Failed");
                        // responseEnt.setResponse("Error returned from CCS - Status Code is "+
                        // statCode);
                        responseEnt.setResponse("Error returned from " + server_name + ":" + statCode);
						if (((cnt != 3)) && (statCode == 503))
						{
						  cnt++;
						  try {
						  TimeUnit.SECONDS.sleep(5); }  //wait for 5 seconds
						  catch (InterruptedException e){System.out.println(e);}
						  resString = json_response(server_name, service_name, json, responseEnt);
						}
                    }
                } else {
                    responseEnt.setStatus("Failed");
                    responseEnt.setResponse("Null returned from " + server_name + " - Invalid Input data");
                }
            } catch (final IOException e) {
                e.printStackTrace();
                throw e;
            }

            /*****************************************************************************************************/

        }

        else if (server_name.equalsIgnoreCase("QLA"))

        {
            /*****************************************************************************************************/
            System.out.println("Service call : Validate FA Legality");
            final URL url = new URL(service_name);

            System.out.println("Connecting to the service...");
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Configure the url connection
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Authorization", "Bearer " + qla_token);
            conn.setRequestProperty("SOURCE", Environment);

            /***************************************************************************************************/
            System.out.println("Execute the Service");
            System.out.println("QLA Request is " + json);

            final ObjectMapper objectMapper = new ObjectMapper();
            final String params = objectMapper.writeValueAsString(json);

            final OutputStream os = conn.getOutputStream();
            os.write(params.getBytes());
            os.flush();
            /****************************************************************************************************/
            final BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            final StringBuilder response = new StringBuilder();

            System.out.println("Reading the response");
            // Read response line by line
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            resString = response.toString();
            System.out.println("QLA Response is " + resString);
        }

        return resString;

    }
}
