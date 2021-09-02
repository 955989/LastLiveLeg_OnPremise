/**
 * @author rswami
 * POJO to store actual time of flight
 **/

package com.aa.entities.ccsResponse;

public class Actual {
    @Override
    public String toString() {
        return "Actual [departureDateTime=" + departureDateTime + ", arrivalDateTime=" + arrivalDateTime + "]";
    }

    private DepartureDateTime departureDateTime;

    private ArrivalDateTime arrivalDateTime;

    public DepartureDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(final DepartureDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public ArrivalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(final ArrivalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }
}
