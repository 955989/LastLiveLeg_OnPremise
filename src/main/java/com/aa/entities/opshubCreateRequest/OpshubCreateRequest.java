/**
 *@author sivan
 *POJO to get opshub details to OpsHub Service
 */

package com.aa.entities.opshubCreateRequest;

public class OpshubCreateRequest {

	private String acknowledgment;
	private Credentials credentials;
	private Requests requests;
	private String sourceSystem;
	private String sourceTimeStamp;

	public String getAcknowledgment() {
		return acknowledgment;
	}

	public void setAcknowledgment(String acknowledgment) {
		this.acknowledgment = acknowledgment;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Requests getRequests() {
		return requests;
	}

	public void setRequests(Requests requests) {
		this.requests = requests;
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
