/**
 *@author sivan
 *POJO to store sequence modification operations details from OpsHub Service
 */

package com.aa.entities.opshub;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SequenceModificationOps {
    private String acknowledgment;

    private Credentials credentials;

    @JsonProperty("requests")
    private ModRequests modrequests;

    private String sourceSystem;

    private String sourceTimeStamp;

    public String getAcknowledgment() {
        return acknowledgment;
    }

    public void setAcknowledgment(final String acknowledgment) {
        this.acknowledgment = acknowledgment;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    public ModRequests getModrequests() {
        return modrequests;
    }

    public void setModrequests(final ModRequests modrequests) {
        this.modrequests = modrequests;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getSourceTimeStamp() {
        return sourceTimeStamp;
    }

    public void setSourceTimeStamp(final String sourceTimeStamp) {
        this.sourceTimeStamp = sourceTimeStamp;
    }

    @Override
    public String toString() {
        return "SequenceModificationOps [acknowledgment=" + acknowledgment + ", credentials=" + credentials
                + ", modrequests=" + modrequests + ", sourceSystem=" + sourceSystem + ", sourceTimeStamp="
                + sourceTimeStamp + "]";
    }

}
