/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubassignResponse;

import java.util.Date;

public class OpshubResponse {

	private String acknowledgment;
	private Credentials credentials;
	private Object expiryDuration;
	private Object expiryTime;
	private Request request;
	private Reply reply;
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

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
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
		return "OpshubResponse [acknowledgment=" + acknowledgment + ", credentials=" + credentials + ", expiryDuration="
				+ expiryDuration + ", expiryTime=" + expiryTime + ", request=" + request + ", reply=" + reply
				+ ", sourceSystem=" + sourceSystem + ", sourceTimeStamp=" + sourceTimeStamp + ", trackingID="
				+ trackingID + "]";
	}

}
