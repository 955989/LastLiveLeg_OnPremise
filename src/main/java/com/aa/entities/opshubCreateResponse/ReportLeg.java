/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

public class ReportLeg {
	private String departureStation;
	private String arrivalStation;
	private String elapsedTime;
	private String oalflightLegDate;
	private String oaldepartureTime;

	public String getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public String getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getOalflightLegDate() {
		return oalflightLegDate;
	}

	public void setOalflightLegDate(String oalflightLegDate) {
		this.oalflightLegDate = oalflightLegDate;
	}

	public String getOaldepartureTime() {
		return oaldepartureTime;
	}

	public void setOaldepartureTime(String oaldepartureTime) {
		this.oaldepartureTime = oaldepartureTime;
	}

	@Override
	public String toString() {
		return "ReportLeg [departureStation=" + departureStation + ", arrivalStation=" + arrivalStation
				+ ", elapsedTime=" + elapsedTime + ", oalflightLegDate=" + oalflightLegDate + ", oaldepartureTime="
				+ oaldepartureTime + "]";
	}

}
