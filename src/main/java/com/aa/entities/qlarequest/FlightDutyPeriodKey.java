/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class FlightDutyPeriodKey {
	private String airlineCode;
	private String contractMonth;
	private int dutyPeriodNumber;
	private String originationDate;
	private String positionCode;
	private int sequenceNumber;

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getContractMonth() {
		return contractMonth;
	}

	public void setContractMonth(String contractMonth) {
		this.contractMonth = contractMonth;
	}

	public int getDutyPeriodNumber() {
		return dutyPeriodNumber;
	}

	public void setDutyPeriodNumber(int dutyPeriodNumber) {
		this.dutyPeriodNumber = dutyPeriodNumber;
	}

	public String getOriginationDate() {
		return originationDate;
	}

	public void setOriginationDate(String originationDate) {
		this.originationDate = originationDate;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

}
