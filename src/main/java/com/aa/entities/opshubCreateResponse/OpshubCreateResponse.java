/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

import java.sql.Date;

public class OpshubCreateResponse {

	private String acknowledgment;
	private Credentials credentials;
	private Object expiryDuration;
	private Object expiryTime;
	private Requests requests;
	private Replies replies;
	private String sourceSystem;
	private Date sourceTimeStamp;
	private Object trackingID;

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

	public Object getExpiryDuration() {
		return expiryDuration;
	}

	public void setExpiryDuration(Object expiryDuration) {
		this.expiryDuration = expiryDuration;
	}

	public Object getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Object expiryTime) {
		this.expiryTime = expiryTime;
	}

	public Requests getRequests() {
		return requests;
	}

	public void setRequests(Requests requests) {
		this.requests = requests;
	}

	public Replies getReplies() {
		return replies;
	}

	public void setReplies(Replies replies) {
		this.replies = replies;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public Date getSourceTimeStamp() {
		return sourceTimeStamp;
	}

	public void setSourceTimeStamp(Date sourceTimeStamp) {
		this.sourceTimeStamp = sourceTimeStamp;
	}

	public Object getTrackingID() {
		return trackingID;
	}

	public void setTrackingID(Object trackingID) {
		this.trackingID = trackingID;
	}

	@Override
	public String toString() {
		return "OpshubCreateResponse [acknowledgment=" + acknowledgment + ", credentials=" + credentials
				+ ", expiryDuration=" + expiryDuration + ", expiryTime=" + expiryTime + ", requests=" + requests
				+ ", replies=" + replies + ", sourceSystem=" + sourceSystem + ", sourceTimeStamp=" + sourceTimeStamp
				+ ", trackingID=" + trackingID + "]";
	}

}
