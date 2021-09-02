/**
 * Developed by Uma Goudar
 * added changes to handle QLA error responses (try/catch block) by sivan kumar
 * commented out the code to fix contractual alert issue by sivan kumar
 */

package com.aa.qlaservices;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.entities.qlaresponse.QlaResponsePayload;

@Service
public class QlaValidation_Legaity {

    @Autowired
    ValidateFA_QLAService_New validate_FA_QLA_Service;

    /**
     * Function modified on 5-Aug-21 by Uma Goudar
     * @author ugoudar
     * @param qlaResponse
     * @return Legal or Not Legal
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws UnrecoverableKeyException
     * @throws NoSuchFieldException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws ParseException
     */
    public String validateLegality(final java.util.List<QlaResponsePayload> qlaResponse)
            throws KeyManagementException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException,
            NoSuchFieldException, KeyStoreException, CertificateException, ParseException {

        String rulename = "";
        String message;

        String messages = "";

        boolean isContractual = true;
        boolean isLegal = true;
        boolean isQualified = true;

        if (qlaResponse != null) {

            // Once the response is received, validate for QLA rules

            final QLARulesConstants qrc = new QLARulesConstants();

            final QlaResponsePayload qlaResp = qlaResponse.get(0);

            try {

                if (qlaResp.getErrorMessages() != null) {
                    int i = 0;
                    final StringBuilder sb = new StringBuilder();

                    while (i < qlaResp.getErrorMessages().size()) {
                        sb.append(qlaResp.getErrorMessages().get(i));
                        i++;
                    }
                    message = sb.toString();
                    return message;
                }

                if (qlaResp.getEmployeeResponses().get(0).getErrors() != null) {
                    int i = 0;
                    final StringBuilder sb = new StringBuilder();

                    while (i < qlaResp.getEmployeeResponses().get(0).getErrors().size()) {
                        sb.append(qlaResp.getEmployeeResponses().get(0).getErrors().get(i));
                        i++;
                    }
                    message = sb.toString();
                    return message;
                }
            } catch (final NullPointerException e) {
                System.out.println("good response from QLA");
            }
            if (qlaResp.getEmployeeResponses().get(0).getQlaResponses().get(0).getRuleResults() != null) {

                final int ruleSize = qlaResp.getEmployeeResponses().get(0).getQlaResponses().get(0).getRuleResults().size();

                for (int ind = 0; ind < ruleSize; ind++) {
                    rulename = qlaResp.getEmployeeResponses().get(0).getQlaResponses().get(0).getRuleResults().get(ind)
                        .getRule();
                    message = qlaResp.getEmployeeResponses().get(0).getQlaResponses().get(0).getRuleResults().get(ind)
                        .getMessages().get(0);

                    System.out.println("rule name for FA1:" + rulename);

                    if (qrc.legalRulesSet.contains(rulename)) {
                        messages = messages + rulename + "-" + message + "\n";

                        isLegal = false;

                        System.out.println(rulename + " rule, message displayed - " + message);
                        System.out.println(rulename + "-" + message);

                    } else if (qrc.qualRulesSet.contains(rulename)) {
                        messages = messages + rulename + "-" + message + "\n";

                        isQualified = false;

                        System.out.println(rulename + " rule, message displayed - " + message);
                        System.out.println(rulename + "-" + message);

                    } else if (qrc.ContractualRulesSet_DenyLLL.contains(rulename)) {
                        messages = messages + rulename + "-" + message + "\n";
                        System.out.println(rulename + " rule, message displayed - " + message);

                        isContractual = false;

                        System.out.println(rulename + "-" + message);

                    }
                }
            } else {
                isLegal = qlaResp.getEmployeeResponses().get(0).getQlaResponses().get(0).isLegal();
                isQualified = qlaResp.getEmployeeResponses().get(0).getQlaResponses().get(0).isContractual();
                isContractual = true;

                if (!isLegal || !isQualified) {
                    messages = "Not Legal!";
                }
            }

            // This block moved out of Else part on 5-Aug-2021 by Uma
            if (isLegal && isContractual && isQualified) {
                messages = "Legal";
            }

        }
        return messages;
    }
}
