/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class LegItem {

	private String arrivalAirport;
	private ArrivalTime arrivalTime;
	private int blockTime;
	private String contractMonth;
	private boolean deadHead;
	private DepartureTime departureTime;
	private int dutyPeriod;
	private String equipmentGroup;
	private String equipmentType;
	private FlightKey flightKey;
	private FlightLegStatusProperties flightLegStatusProperties;
	private boolean international;
	private Object languageQuals;
	private OalArrivalDateTime oalArrivalDateTime;
	private OalDepartureDateTime oalDepartureDateTime;
	private String oalSurfaceAirline;
	private String visaCountry;
	private String visaIndicator;

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public ArrivalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(ArrivalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getBlockTime() {
		return blockTime;
	}

	public void setBlockTime(int blockTime) {
		this.blockTime = blockTime;
	}

	public String getContractMonth() {
		return contractMonth;
	}

	public void setContractMonth(String contractMonth) {
		this.contractMonth = contractMonth;
	}

	public boolean isDeadHead() {
		return deadHead;
	}

	public void setDeadHead(boolean deadHead) {
		this.deadHead = deadHead;
	}

	public DepartureTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(DepartureTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getDutyPeriod() {
		return dutyPeriod;
	}

	public void setDutyPeriod(int dutyPeriod) {
		this.dutyPeriod = dutyPeriod;
	}

	public String getEquipmentGroup() {
		return equipmentGroup;
	}

	public void setEquipmentGroup(String equipmentGroup) {
		this.equipmentGroup = equipmentGroup;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public FlightKey getFlightKey() {
		return flightKey;
	}

	public void setFlightKey(FlightKey flightKey) {
		this.flightKey = flightKey;
	}

	public FlightLegStatusProperties getFlightLegStatusProperties() {
		return flightLegStatusProperties;
	}

	public void setFlightLegStatusProperties(FlightLegStatusProperties flightLegStatusProperties) {
		this.flightLegStatusProperties = flightLegStatusProperties;
	}

	public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public Object getLanguageQuals() {
		return languageQuals;
	}

	public void setLanguageQuals(Object languageQuals) {
		this.languageQuals = languageQuals;
	}

	public OalArrivalDateTime getOalArrivalDateTime() {
		return oalArrivalDateTime;
	}

	public void setOalArrivalDateTime(OalArrivalDateTime oalArrivalDateTime) {
		this.oalArrivalDateTime = oalArrivalDateTime;
	}

	public OalDepartureDateTime getOalDepartureDateTime() {
		return oalDepartureDateTime;
	}

	public void setOalDepartureDateTime(OalDepartureDateTime oalDepartureDateTime) {
		this.oalDepartureDateTime = oalDepartureDateTime;
	}

	public String getOalSurfaceAirline() {
		return oalSurfaceAirline;
	}

	public void setOalSurfaceAirline(String oalSurfaceAirline) {
		this.oalSurfaceAirline = oalSurfaceAirline;
	}

	public String getVisaCountry() {
		return visaCountry;
	}

	public void setVisaCountry(String visaCountry) {
		this.visaCountry = visaCountry;
	}

	public String getVisaIndicator() {
		return visaIndicator;
	}

	public void setVisaIndicator(String visaIndicator) {
		this.visaIndicator = visaIndicator;
	}

}
