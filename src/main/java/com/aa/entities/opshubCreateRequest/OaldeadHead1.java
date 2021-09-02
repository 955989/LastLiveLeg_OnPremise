/**
 *@author sivan
 *POJO to get opshub details to OpsHub Service
 */

package com.aa.entities.opshubCreateRequest;

public class OaldeadHead1 {

	private String idPlusFlighNum;
	private String oalflightLegDate;
	private String departureStation;
	private String arrivalStation;
	private String oaldepartureTime;
	private String oalarrivalTime;
	private String deadHeadNormalCockpit;

	public String getIdPlusFlighNum() {
		return idPlusFlighNum;
	}

	public void setIdPlusFlighNum(String idPlusFlighNum) {
		this.idPlusFlighNum = idPlusFlighNum;
	}

	public String getOalflightLegDate() {
		return oalflightLegDate;
	}

	public void setOalflightLegDate(String oalflightLegDate) {
		this.oalflightLegDate = oalflightLegDate;
	}

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

	public String getOaldepartureTime() {
		return oaldepartureTime;
	}

	public void setOaldepartureTime(String string) {
		this.oaldepartureTime = string;
	}

	public String getOalarrivalTime() {
		return oalarrivalTime;
	}

	public void setOalarrivalTime(String string) {
		this.oalarrivalTime = string;
	}

	public String getDeadHeadNormalCockpit() {
		return deadHeadNormalCockpit;
	}

	public void setDeadHeadNormalCockpit(String deadHeadNormalCockpit) {
		this.deadHeadNormalCockpit = deadHeadNormalCockpit;
	}

	@Override
	public String toString() {
		return "OaldeadHead1 [idPlusFlighNum=" + idPlusFlighNum + ", oalflightLegDate=" + oalflightLegDate
				+ ", departureStation=" + departureStation + ", arrivalStation=" + arrivalStation
				+ ", oaldepartureTime=" + oaldepartureTime + ", oalarrivalTime=" + oalarrivalTime
				+ ", deadHeadNormalCockpit=" + deadHeadNormalCockpit + "]";
	}

}
