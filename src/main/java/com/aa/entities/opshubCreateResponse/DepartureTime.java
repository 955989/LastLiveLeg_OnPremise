
/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */
package com.aa.entities.opshubCreateResponse;

public class DepartureTime {
	private String value;
	private Object sendToRes;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Object getSendToRes() {
		return sendToRes;
	}

	public void setSendToRes(Object sendToRes) {
		this.sendToRes = sendToRes;
	}

	@Override
	public String toString() {
		return "DepartureTime [value=" + value + ", sendToRes=" + sendToRes + "]";
	}

}