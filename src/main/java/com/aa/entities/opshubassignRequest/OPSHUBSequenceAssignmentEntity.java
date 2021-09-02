/**
 *@author sivan
 *POJO to store opshub assignment details to OpsHub Service
 */

package com.aa.entities.opshubassignRequest;


public class OPSHUBSequenceAssignmentEntity {
	private String acknowledgment;
	private OpshubCredentials CredentialsObject;
	private OpshubRequest RequestObject;
	private String sourceSystem;
	private String sourceTimeStamp;

	// Getter Methods

	public String getAcknowledgment() {
		return acknowledgment;
	}

	public OpshubCredentials getCredentials() {
		return CredentialsObject;
	}

	public OpshubRequest getRequest() {
		return RequestObject;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public String getSourceTimeStamp() {
		return sourceTimeStamp;
	}

	// Setter Methods

	public void setAcknowledgment(String acknowledgment) {
		this.acknowledgment = acknowledgment;
	}

	public void setCredentials(OpshubCredentials credentialsObject) {
		this.CredentialsObject = credentialsObject;
	}

	public void setRequest(OpshubRequest requestObject) {
		this.RequestObject = requestObject;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public void setSourceTimeStamp(String sourceTimeStamp) {
		this.sourceTimeStamp = sourceTimeStamp;
	}
}
