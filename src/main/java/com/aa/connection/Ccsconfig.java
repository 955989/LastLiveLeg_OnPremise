/**
 * @author skumar
 * CCS certificate path
 */
package com.aa.connection;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("opshub")

public class Ccsconfig {

    private String certificatePath;

    /**
     * @return the certificatePath
     */
    public String getCertificatePath() {
        return certificatePath;
    }

    /**
     * @param certificatePath
     *            the certificatePath to set
     */
    public void setCertificatePath(final String certificatePath) {
        this.certificatePath = certificatePath;
    }

}
