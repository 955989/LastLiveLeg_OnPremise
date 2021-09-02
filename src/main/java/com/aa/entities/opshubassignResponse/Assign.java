/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubassignResponse;

public class Assign {
	private int employeeNumber;
	private String seat;
	private int sequenceNumber;
	private String sequenceOriginDate;
	private String reasonCode;
	private Object swapSeat;
	private Object applicationID;
	private Object process;

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getSequenceOriginDate() {
		return sequenceOriginDate;
	}

	public void setSequenceOriginDate(String sequenceOriginDate) {
		this.sequenceOriginDate = sequenceOriginDate;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public Object getSwapSeat() {
		return swapSeat;
	}

	public void setSwapSeat(Object swapSeat) {
		this.swapSeat = swapSeat;
	}

	public Object getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(Object applicationID) {
		this.applicationID = applicationID;
	}

	public Object getProcess() {
		return process;
	}

	public void setProcess(Object process) {
		this.process = process;
	}

	@Override
	public String toString() {
		return "Assign [employeeNumber=" + employeeNumber + ", seat=" + seat + ", sequenceNumber=" + sequenceNumber
				+ ", sequenceOriginDate=" + sequenceOriginDate + ", reasonCode=" + reasonCode + ", swapSeat=" + swapSeat
				+ ", applicationID=" + applicationID + ", process=" + process + "]";
	}

}