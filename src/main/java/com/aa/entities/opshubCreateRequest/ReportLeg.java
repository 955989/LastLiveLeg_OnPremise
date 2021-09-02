
/**
 *@author sivan
 *POJO to get opshub details to OpsHub Service
 */

package com.aa.entities.opshubCreateRequest;

public class ReportLeg {

	private String departureStation;
	private String arrivalStation;
	private String elapsedTime;
	private String oaldepartureTime;
	private String oalflightLegDate;

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

	public String getOaldepartureTime() {
		return oaldepartureTime;
	}

	public void setOaldepartureTime(String string) {
		this.oaldepartureTime = string;
	}

	public String getOalflightLegDate() {
		return oalflightLegDate;
	}

	public void setOalflightLegDate(String oalflightLegDate) {
		this.oalflightLegDate = oalflightLegDate;
	}

}
