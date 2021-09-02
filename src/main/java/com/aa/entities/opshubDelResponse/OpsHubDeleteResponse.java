/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubDelResponse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpsHubDeleteResponse {
	private String acknowledgment;
	@JsonProperty("credentials")
	private Credentials_del credentials;

	private Object expiryDuration;
	private Object expiryTime;

	@JsonProperty("request")
	private Request_del request;

	@JsonProperty("reply")
	private Reply_del reply;
	private String sourceSystem;

	private Date sourceTimeStamp;
	private Object trackingID;

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

	public Request_del getRequest() {
		return request;
	}

	public void setRequest(Request_del request) {
		this.request = request;
	}

	public Reply_del getReply() {
		return reply;
	}

	public void setReply(Reply_del reply) {
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
		return "root_del [acknowledgment=" + acknowledgment + ", credentials=" + credentials + ", expiryDuration="
				+ expiryDuration + ", expiryTime=" + expiryTime + ", request=" + request + ", reply=" + reply
				+ ", sourceSystem=" + sourceSystem + ", sourceTimeStamp=" + sourceTimeStamp + ", trackingID="
				+ trackingID + "]";
	}

}
