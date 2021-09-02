/**
 * Pojo to store leg details of a sequence
 */

package com.aa.entities.ccsentities;

public class LegDetailsEntity {

    private String flightDate;

    private String valEQ;

    private String flightNumber;

    private String departureCity;

    private String departureTime;

    private String ArrivalCity;

    private String arrivalTime;

    private String flyHours;

    private String flightType;

    public LegDetailsEntity() {
        super();
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(final String flightDate) {
        this.flightDate = flightDate;
    }

    public String getValEQ() {
        return valEQ;
    }

    public void setValEQ(final String valEQ) {
        this.valEQ = valEQ;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(final String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(final String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(final String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalCity() {
        return ArrivalCity;
    }

    public void setArrivalCity(final String arrivalCity) {
        ArrivalCity = arrivalCity;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(final String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFlyHours() {
        return flyHours;
    }

    public void setFlyHours(final String flyHours) {
        this.flyHours = flyHours;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(final String flightType) {
        this.flightType = flightType;
    }

    @Override
    public String toString() {
        return "LegDetails [flightDate=" + flightDate + ", valEQ=" + valEQ + ", flightNumber=" + flightNumber
                + ", departureCity=" + departureCity + ", departureTime=" + departureTime + ", ArrivalCity="
                + ArrivalCity + ", arrivalTime=" + arrivalTime + ", flyHours=" + flyHours + ", flightType=" + flightType
                + ", getFlightDate()=" + getFlightDate() + ", getValEQ()=" + getValEQ() + ", getFlightNumber()="
                + getFlightNumber() + ", getDepartureCity()=" + getDepartureCity() + ", getDepartureTime()="
                + getDepartureTime() + ", getArrivalCity()=" + getArrivalCity() + ", getArrivalTime()="
                + getArrivalTime() + ", getFlyHours()=" + getFlyHours() + ", getFlightType()=" + getFlightType()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

}
