/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubDelRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root_del {
	private String acknowledgment;
	@JsonProperty("credentials")
	private Credentials_del credentials;

	@JsonProperty("request")
	private Request_del request;

	private String sourceSystem;
	private String sourceTimeStamp;

	public String getAcknowledgment() {
		return acknowledgment;
	}

	public void setAcknowledgment(String acknowledgment) {
		this.acknowledgment = acknowledgment;
	}

	public Credentials_del getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials_del credentials) {
		this.credentials = credentials;
	}

	public Request_del getRequest() {
		return request;
	}

	public void setRequest(Request_del request) {
		this.request = request;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getSourceTimeStamp() {
		return sourceTimeStamp;
	}

	public void setSourceTimeStamp(String sourceTimeStamp) {
		this.sourceTimeStamp = sourceTimeStamp;
	}

}
