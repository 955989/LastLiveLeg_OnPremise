/**
 *@author sivan
 *POJO to store oal deadhead details from OpsHub Service
 */

package com.aa.entities.opshub;

public class OaldeadHead {

    private String idPlusFlighNum;

    private String oalflightLegDate;

    private String departureStation;

    private String arrivalStation;

    private String oaldepartureTime;

    private String oalarrivalTime;

    public String getIdPlusFlighNum() {
        return idPlusFlighNum;
    }

    public void setIdPlusFlighNum(final String idPlusFlighNum) {
        this.idPlusFlighNum = idPlusFlighNum;
    }

    public String getOalflightLegDate() {
        return oalflightLegDate;
    }

    public void setOalflightLegDate(final String oalflightLegDate) {
        this.oalflightLegDate = oalflightLegDate;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(final String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(final String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getOaldepartureTime() {
        return oaldepartureTime;
    }

    public void setOaldepartureTime(final String string) {
        this.oaldepartureTime = string;
    }

    public String getOalarrivalTime() {
        return oalarrivalTime;
    }

    public void setOalarrivalTime(final String string) {
        this.oalarrivalTime = string;
    }

    @Override
    public String toString() {
        return "OaldeadHead [idPlusFlighNum=" + idPlusFlighNum + ", oalflightLegDate=" + oalflightLegDate
                + ", departureStation=" + departureStation + ", arrivalStation=" + arrivalStation
                + ", oaldepartureTime=" + oaldepartureTime + ", oalarrivalTime=" + oalarrivalTime + "]";
    }

}
