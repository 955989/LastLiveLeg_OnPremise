/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

public class NormalFlightLeg {
	private String flightNumber;
	private String flightOriginDate;
	private String departureStation;
	private DepartureTime departureTime;
	private String deadHeadNormalCockpit;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightOriginDate() {
		return flightOriginDate;
	}

	public void setFlightOriginDate(String flightOriginDate) {
		this.flightOriginDate = flightOriginDate;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public DepartureTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(DepartureTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getDeadHeadNormalCockpit() {
		return deadHeadNormalCockpit;
	}

	public void setDeadHeadNormalCockpit(String deadHeadNormalCockpit) {
		this.deadHeadNormalCockpit = deadHeadNormalCockpit;
	}

	@Override
	public String toString() {
		return "NormalFlightLeg [flightNumber=" + flightNumber + ", flightOriginDate=" + flightOriginDate
				+ ", departureStation=" + departureStation + ", departureTime=" + departureTime
				+ ", deadHeadNormalCockpit=" + deadHeadNormalCockpit + "]";
	}

}