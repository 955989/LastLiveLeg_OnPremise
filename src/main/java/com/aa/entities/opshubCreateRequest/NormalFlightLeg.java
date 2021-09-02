/**
 *@author sivan
 *POJO to get opshub details to OpsHub Service
 */

package com.aa.entities.opshubCreateRequest;

public class NormalFlightLeg {

	private String flightNumber;
	private String flightOriginDate;
	private String departureStation;
	private OH_DepartureTime departureTime;
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

	public OH_DepartureTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(OH_DepartureTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getDeadHeadNormalCockpit() {
		return deadHeadNormalCockpit;
	}

	public void setDeadHeadNormalCockpit(String deadHeadNormalCockpit) {
		this.deadHeadNormalCockpit = deadHeadNormalCockpit;
	}

}
