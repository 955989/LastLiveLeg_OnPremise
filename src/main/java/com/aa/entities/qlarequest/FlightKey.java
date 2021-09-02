/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class FlightKey {
	private String airlineCode;
	private String departureAirport;
	private int departureStationDupe;
	private String flightNumber;
	private String flightOriginationDate;
	private int legIndex;

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public int getDepartureStationDupe() {
		return departureStationDupe;
	}

	public void setDepartureStationDupe(int departureStationDupe) {
		this.departureStationDupe = departureStationDupe;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightOriginationDate() {
		return flightOriginationDate;
	}

	public void setFlightOriginationDate(String flightOriginationDate) {
		this.flightOriginationDate = flightOriginationDate;
	}

	public int getLegIndex() {
		return legIndex;
	}

	public void setLegIndex(int legIndex) {
		this.legIndex = legIndex;
	}

}
