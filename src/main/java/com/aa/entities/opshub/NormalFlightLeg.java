/**
 *@author sivan
 *POJO to store normal flight leg details from OpsHub Service
 */

package com.aa.entities.opshub;

public class NormalFlightLeg {

    private String flightNumber;

    private String flightOriginDate;

    private String departureStation;

    private String deadHeadNormalCockpit;

    public String getDeadHeadNormalCockpit() {
        return deadHeadNormalCockpit;
    }

    public void setDeadHeadNormalCockpit(final String deadHeadNormalCockpit) {
        this.deadHeadNormalCockpit = deadHeadNormalCockpit;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(final String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightOriginDate() {
        return flightOriginDate;
    }

    public void setFlightOriginDate(final String flightOriginDate) {
        this.flightOriginDate = flightOriginDate;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(final String departureStation) {
        this.departureStation = departureStation;
    }

    @Override
    public String toString() {
        return "NormalFlightLeg [flightNumber=" + flightNumber + ", flightOriginDate=" + flightOriginDate
                + ", departureStation=" + departureStation + "]";
    }

}
