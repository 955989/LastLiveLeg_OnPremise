/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

public class NormalFlightLeg {

	private String flightNumber;
	private String flightOriginDate;
	private String departureStation;
	private Object departureTime;

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

	public Object getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Object departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "NormalFlightLeg [flightNumber=" + flightNumber + ", flightOriginDate=" + flightOriginDate
				+ ", departureStation=" + departureStation + ", departureTime=" + departureTime + "]";
	}

}
