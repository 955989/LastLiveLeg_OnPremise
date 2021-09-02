/**
 *@author sivan
 *POJO to store oal deadhead deleted details from OpsHub Service
 */

package com.aa.entities.opshub;

public class OaldeadHeaddel {

    private String idPlusFlighNum;

    private String oalflightLegDate;

    private String departureStation;

    private String arrivalStation;

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

    @Override
    public String toString() {
        return "OaldeadHeaddel [idPlusFlighNum=" + idPlusFlighNum + ", oalflightLegDate=" + oalflightLegDate
                + ", departureStation=" + departureStation + ", arrivalStation=" + arrivalStation + "]";
    }

}
