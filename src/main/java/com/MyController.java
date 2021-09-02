/**
 * Controller file
 */
package com;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.ParseException;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.aa.ccsservices.CCS_getSequenceDetailsByKeysNew;
import com.aa.crew.apigee.AccessTokenClientImpl;
import com.aa.entities.ResponseEntity;
import com.aa.entities.SequenceDetailsEntity;
import com.aa.lastliveleg.LastLiveLeg_DH_Domestic_Trade;
import com.aa.qlaservices.QlaValidation_Legaity;

@RestController
// @EnableAsync
//@EnableScheduling
//@PropertySource("application.properties")
public class MyController {

    @Autowired
    private LastLiveLeg_DH_Domestic_Trade ldt;

    @Autowired
    private AccessTokenClientImpl token;

    @Autowired
    private QlaValidation_Legaity runQlaService;

    @Autowired
    private CCS_getSequenceDetailsByKeysNew ccsCall;

    @Async
    @Scheduled(fixedDelay = 840000) // 840000 Every 14 minutes the token will get generated
    public void scheduleFixedDelayTask()
            throws KeyManagementException, NoSuchAlgorithmException, NoSuchFieldException, IOException {
        try {
            token.get_token_for_all();
        } catch (final Exception ex) {
            final StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            final String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
        }
    }

//    @PostMapping(path = {"/test/trade_lll","/dev/trade_lll","/prod/trade_lll"}, consumes = "application/json")
    @PostMapping(path = "/trade_lll", consumes = "application/json")
    
    public CompletableFuture<ResponseEntity> calltradeLLL(@RequestBody final SequenceDetailsEntity sd,HttpServletRequest request)
            throws NoSuchFieldException, IOException, AWTException, InterruptedException, ParseException,
            org.json.simple.parser.ParseException, ParserConfigurationException, SAXException, KeyManagementException,
            NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, CertificateException,
            org.apache.tomcat.util.json.ParseException {
    	
    		String env = request.getRequestURL().toString();
//    	if(env.contains("dev")) {
//    		spring.profiles.active="dev";
//    		
//    	}
            CompletableFuture<ResponseEntity> response = new CompletableFuture<ResponseEntity>();
            response = ldt.tradeLLL(sd); 
            return response;
    }
    
    

   
}
