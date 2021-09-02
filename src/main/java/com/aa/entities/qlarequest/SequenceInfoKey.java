/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class SequenceInfoKey {
	private String airlineCode;
	private String baseIndicator;
	private String contractMonth;
	private String originationDate;
	private String positionCode;
	private int sequenceNumber;

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getBaseIndicator() {
		return baseIndicator;
	}

	public void setBaseIndicator(String baseIndicator) {
		this.baseIndicator = baseIndicator;
	}

	public String getContractMonth() {
		return contractMonth;
	}

	public void setContractMonth(String contractMonth) {
		this.contractMonth = contractMonth;
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

	@Override
	public String toString() {
		return "SequenceInfoKey [airlineCode=" + airlineCode + ", baseIndicator=" + baseIndicator + ", contractMonth="
				+ contractMonth + ", originationDate=" + originationDate + ", positionCode=" + positionCode
				+ ", sequenceNumber=" + sequenceNumber + "]";
	}

}
