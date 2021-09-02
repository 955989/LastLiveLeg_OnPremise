/**
 * @author rswami
 * POJO to get flight LEG DTO from CCS service
 **/

package com.aa.entities.ccsResponse;

import java.util.List;

public class FlightLegDTO {

    private String airlineCode;

    private String legType;

    private List<String> legStatuses;

    private int flightNumber;

    private int legIndex;

    private String arrivalStation;

    private String departureStation;

    private String flightOriginationDate;

    private String visaIndicator;

    private String visaCountry;

    private EquipmentQuals equipmentQuals;

    private int blockTime;

    private int groundTime;

    private boolean deadHead;

    public Scheduled scheduled;

    public ReScheduled reScheduled;

    public ReScheduled getReScheduled() {
        return reScheduled;
    }

    public void setReScheduled(final ReScheduled reScheduled) {
        this.reScheduled = reScheduled;
    }

    public Actual actual;

    private String deadHeadAirlineCode;

    private DelayMinutes delayMinutes;

    private int departureDuplicateCode;

    private int arrivalDuplicateCode;

    private boolean noShowDHD;

    private boolean active;

    private boolean cancelled;

    private boolean removed;

    private int greaterTime;

    private int diversionTime;

    private String actualSeat;

    private boolean signedIn;

    private boolean isIPD;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public DelayMinutes getDelayMinutes() {
        return delayMinutes;
    }

    public void setDelayMinutes(final DelayMinutes delayMinutes) {
        this.delayMinutes = delayMinutes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(final boolean removed) {
        this.removed = removed;
    }

    public int getGreaterTime() {
        return greaterTime;
    }

    public void setGreaterTime(final int greaterTime) {
        this.greaterTime = greaterTime;
    }

    public int getDiversionTime() {
        return diversionTime;
    }

    public void setDiversionTime(final int diversionTime) {
        this.diversionTime = diversionTime;
    }

    public String getActualSeat() {
        return actualSeat;
    }

    public void setActualSeat(final String actualSeat) {
        this.actualSeat = actualSeat;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    public void setSignedIn(final boolean signedIn) {
        this.signedIn = signedIn;
    }

    public boolean isIPD() {
        return isIPD;
    }

    public void setIPD(final boolean isIPD) {
        this.isIPD = isIPD;
    }

    public boolean isEndOfDutyPeriod() {
        return endOfDutyPeriod;
    }

    public void setEndOfDutyPeriod(final boolean endOfDutyPeriod) {
        this.endOfDutyPeriod = endOfDutyPeriod;
    }

    public boolean isEndOfSequence() {
        return endOfSequence;
    }

    public void setEndOfSequence(final boolean endOfSequence) {
        this.endOfSequence = endOfSequence;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(final boolean international) {
        this.international = international;
    }

    public boolean isStartOfDutyPeriod() {
        return startOfDutyPeriod;
    }

    public void setStartOfDutyPeriod(final boolean startOfDutyPeriod) {
        this.startOfDutyPeriod = startOfDutyPeriod;
    }

    public boolean isPosLangPremPay() {
        return posLangPremPay;
    }

    public void setPosLangPremPay(final boolean posLangPremPay) {
        this.posLangPremPay = posLangPremPay;
    }

    private boolean endOfDutyPeriod;

    private boolean endOfSequence;

    private boolean international;

    private boolean startOfDutyPeriod;

    private boolean posLangPremPay;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(final String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getLegType() {
        return legType;
    }

    public void setLegType(final String legType) {
        this.legType = legType;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(final int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getLegIndex() {
        return legIndex;
    }

    public void setLegIndex(final int legIndex) {
        this.legIndex = legIndex;
    }

    public String getFlightOriginationDate() {
        return flightOriginationDate;
    }

    public void setFlightOriginationDate(final String flightOriginationDate) {
        this.flightOriginationDate = flightOriginationDate;
    }

    public String getVisaIndicator() {
        return visaIndicator;
    }

    public void setVisaIndicator(final String visaIndicator) {
        this.visaIndicator = visaIndicator;
    }

    public String getVisaCountry() {
        return visaCountry;
    }

    public void setVisaCountry(final String visaCountry) {
        this.visaCountry = visaCountry;
    }

    public EquipmentQuals getEquipmentQuals() {
        return equipmentQuals;
    }

    public void setEquipmentQuals(final EquipmentQuals equipmentQuals) {
        this.equipmentQuals = equipmentQuals;
    }

    public int getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(final int blockTime) {
        this.blockTime = blockTime;
    }

    public int getGroundTime() {
        return groundTime;
    }

    public void setGroundTime(final int groundTime) {
        this.groundTime = groundTime;
    }

    public boolean isDeadHead() {
        return deadHead;
    }

    public void setDeadHead(final boolean deadHead) {
        this.deadHead = deadHead;
    }

    public String getDeadHeadAirlineCode() {
        return deadHeadAirlineCode;
    }

    public void setDeadHeadAirlineCode(final String deadHeadAirlineCode) {
        this.deadHeadAirlineCode = deadHeadAirlineCode;
    }

    public Actual getActual() {
        return actual;
    }

    public void setActual(final Actual actual) {
        this.actual = actual;
    }

    public Scheduled getScheduled() {
        return scheduled;
    }

    public void setScheduled(final Scheduled scheduled) {
        this.scheduled = scheduled;
    }

    public int getDepartureDuplicateCode() {
        return departureDuplicateCode;
    }

    public void setDepartureDuplicateCode(final int departureDuplicateCode) {
        this.departureDuplicateCode = departureDuplicateCode;
    }

    public int getArrivalDuplicateCode() {
        return arrivalDuplicateCode;
    }

    public void setArrivalDuplicateCode(final int arrivalDuplicateCode) {
        this.arrivalDuplicateCode = arrivalDuplicateCode;
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

    public boolean isNoShowDHD() {
        return noShowDHD;
    }

    public void setNoShowDHD(final boolean noShowDHD) {
        this.noShowDHD = noShowDHD;
    }

    @Override
    public String toString() {
        return "FlightLegDTO [airlineCode=" + airlineCode + ", legType=" + legType + ", legStatuses=" + legStatuses
                + ", flightNumber=" + flightNumber + ", legIndex=" + legIndex + ", arrivalStation=" + arrivalStation
                + ", departureStation=" + departureStation + ", flightOriginationDate=" + flightOriginationDate
                + ", visaIndicator=" + visaIndicator + ", visaCountry=" + visaCountry + ", equipmentQuals="
                + equipmentQuals + ", blockTime=" + blockTime + ", groundTime=" + groundTime + ", deadHead=" + deadHead
                + ", scheduled=" + scheduled + ", actual=" + actual + ", deadHeadAirlineCode=" + deadHeadAirlineCode
                + ", delayMinutes=" + delayMinutes + ", departureDuplicateCode=" + departureDuplicateCode
                + ", arrivalDuplicateCode=" + arrivalDuplicateCode + ", noShowDHD=" + noShowDHD + ", active=" + active
                + ", cancelled=" + cancelled + ", removed=" + removed + ", greaterTime=" + greaterTime
                + ", diversionTime=" + diversionTime + ", actualSeat=" + actualSeat + ", signedIn=" + signedIn
                + ", isIPD=" + isIPD + ", status=" + status + ", endOfDutyPeriod=" + endOfDutyPeriod
                + ", endOfSequence=" + endOfSequence + ", international=" + international + ", startOfDutyPeriod="
                + startOfDutyPeriod + ", posLangPremPay=" + posLangPremPay + "]";
    }

    public List<String> getLegStatuses() {
        return legStatuses;
    }

    public void setLegStatuses(final List<String> legStatuses) {
        this.legStatuses = legStatuses;
    }
}
