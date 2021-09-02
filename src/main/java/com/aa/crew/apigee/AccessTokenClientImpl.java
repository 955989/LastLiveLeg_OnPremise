/**
 * @author Sivan
 * This is to generate QLA token.
 */

package com.aa.crew.apigee;

import java.io.BufferedReader;

//import com.aa.lll.config.CCSProperties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Map;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import com.aa.lll.config.CCSProperties;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class AccessTokenClientImpl {

    @Value("${ccs.accessTokenUsername}")
    private String ccsaccessTokenUsername;

    @Value("${ccs.accessTokenPassword}")
    private String ccsaccessTokenPassword;

    @Value("${opshub_Apigee_Username}")
    private String opshubApigeeUsername;

    @Value("${opshub_Apigee_Password}")
    private String opshubApigeePassword;

    @Value("${qla_accessTokenUsername}")
    private String qlaApigeeUsername;

    @Value("${qla_accessTokenPassword}")
    private String qlaApigeeTokenPassword;

    @Value("${Apigee_TokenUrl}")
    private String TokenUrl;

    private static String qla;

    private static String ccs;

    public String getQLA() {
        return qla;
    }

    public String getCCS() {
        return ccs;
    }

    public void get_token_for_all() throws KeyManagementException, NoSuchAlgorithmException, NoSuchFieldException, IOException {

        final Properties properties = new Properties();

        qla = getAccessToken("QLA");
        ccs = getAccessToken("CCS");
        ccs = ccs.trim();
        qla = qla.trim();

        System.out.println("Tokens updated in static variables..");

    }

    public String getAccessToken(final String type)
            throws NoSuchAlgorithmException, KeyManagementException, IOException, NoSuchFieldException {

        // Create a trust manager that does not validate certificate chains
        final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(final X509Certificate[] certs, final String authType) {
            }

            @Override
            public void checkServerTrusted(final X509Certificate[] certs, final String authType) {
            }
        }
        };

        // Install the all-trusting trust manager
        final SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        final HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(final String hostname, final SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        final StringBuilder data = new StringBuilder();
        data.append("grant_type=client_credentials");
        final byte[] byteArray = data.toString().getBytes("UTF-8");
        final URL url = new URL(TokenUrl);
        final HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setConnectTimeout(5000);
        con.setDoOutput(true);

        String combineauth = null;

        if (type.equalsIgnoreCase("OPSHUB")) {

            combineauth = opshubApigeeUsername + ":" + opshubApigeePassword;
        }

        if (type.equalsIgnoreCase("CCS")) {

            combineauth = ccsaccessTokenUsername + ":" + ccsaccessTokenPassword;
        }

        if (type.equalsIgnoreCase("QLA")) {

            combineauth = qlaApigeeUsername + ":" + qlaApigeeTokenPassword;
        }

        final String auth = combineauth;

        // final String auth = accessTokenUsername + ":" + accessTokenPassword ;
        final Base64.Encoder encode = Base64.getEncoder();
        final byte[] base64Token = encode.encode(auth.getBytes());
        final String authId = new String(base64Token);

        con.setRequestProperty("Authorization", "Basic " + authId);
        final OutputStream postStream = con.getOutputStream();
        postStream.write(byteArray, 0, byteArray.length);
        postStream.close();

        final InputStreamReader reader = new InputStreamReader(con.getInputStream());
        final BufferedReader in = new BufferedReader(reader);
        final String json = in.readLine();
        System.out.println("Json String = " + json);

        // Parse the Json response and retrieve the Access Token
        final Gson gson = new Gson();
        final Type mapType = new TypeToken<Map<String, String>>() {
        }.getType();
        final Map<String, String> ser = gson.fromJson(json, mapType);
        final String accessToken = ser.get("access_token");
        System.out.println("Access Token = " + accessToken);
        in.close();
        con.disconnect();
        return accessToken;
    }

}
