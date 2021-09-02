/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

public class OaldeadHead {

	private String idPlusFlighNum;
	private String departureStation;
	private String arrivalStation;
	private Object deadHeadNormalCockpit;
	private String oalflightLegDate;
	private String oaldepartureTime;
	private String oalarrivalTime;

	public String getIdPlusFlighNum() {
		return idPlusFlighNum;
	}

	public void setIdPlusFlighNum(String idPlusFlighNum) {
		this.idPlusFlighNum = idPlusFlighNum;
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

	public Object getDeadHeadNormalCockpit() {
		return deadHeadNormalCockpit;
	}

	public void setDeadHeadNormalCockpit(Object deadHeadNormalCockpit) {
		this.deadHeadNormalCockpit = deadHeadNormalCockpit;
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

	public String getOalarrivalTime() {
		return oalarrivalTime;
	}

	public void setOalarrivalTime(String oalarrivalTime) {
		this.oalarrivalTime = oalarrivalTime;
	}

	@Override
	public String toString() {
		return "OaldeadHead [idPlusFlighNum=" + idPlusFlighNum + ", departureStation=" + departureStation
				+ ", arrivalStation=" + arrivalStation + ", deadHeadNormalCockpit=" + deadHeadNormalCockpit
				+ ", oalflightLegDate=" + oalflightLegDate + ", oaldepartureTime=" + oaldepartureTime
				+ ", oalarrivalTime=" + oalarrivalTime + "]";
	}

}
