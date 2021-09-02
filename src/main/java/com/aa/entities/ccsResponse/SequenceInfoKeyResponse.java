/**
 * @author rswami
 * POJO to get sequence info key details from CCS service
 */

package com.aa.entities.ccsResponse;

import java.util.List;

public class SequenceInfoKeyResponse {

    private String airlineCode;

    private String base;

    private String cabinType;

    private String contractMonth;

    private String addCode;

    private String sequenceOriginDate;

    private int sequenceNumber;

    private String positionCode;

    private String division;

    private int employeeID;

    private int durationInDays;

    private SequenceStartDateTime sequenceStartDateTime;

    private SequenceEndDateTime sequenceEndDateTime;

    private String legsPerDutyPeriod;

    private int numberOfLegs;

    private CCSDateTimeDTO firstLegDepartureTime;

    private String firstLegDepartureAirport;

    private String landingQuals;

    private String equipmentGroup;// equipment

    private int creditThisMonth;// seqValue/60

    private int creditNextMonth;

    private int scheduledFlight;

    private String positionSequenceInfo1;

    private String positionSequenceInfo1Binary;

    private String positionSequenceInfo2;

    private boolean assignedStandbyShift;

    private boolean awardedStandbyShift;

    public boolean lastSequencePayProtection;

    private List<FlightDutyPeriodDTO> flightDutyPeriods;// numDp FlightDutyPeriod

    private SpeakerRequirement speakerRequirement;// language

    private List<ServiceQuals> serviceQuals;

    private String signInTimeBase;

    private String signInTimeInGMT;

    private boolean failsContinuity;//

    private boolean galleyPosition;//

    private int totalLegCount;

    private SequencePayCredit sequencePayCredit;

    private int sequenceBlockTime;

    private int sequencePayTime;

    private String sequenceDutyTime;

    private boolean international;

    private int timeAwayFromBase;

    private boolean isSatellite;

    private boolean isCoterminal;

    private boolean isIPD;

    private boolean isNIPD;

    private boolean isODAN;

    private boolean isRedEye;

    private boolean isRedFlag;

    private boolean isTrainingSequence;

    private boolean firstLegDeadHeadIndicator;

    private boolean lastLegDeadHeadIndicator;

    private String layoverStations;

    private String lastLegArrivalAirport;

    private LastLegArrivalTime lastLegArrivalTime;

    private String timeOpened;

    private int totalOpenPositionsForSeq;

    private int totalOpenPositionsForCabin;

    private String removalCode;

    private boolean multipleEquipments;

    private boolean noShowDHD;

    private boolean observationTrip;

    private boolean ttInhibited;

    private boolean purser;

    private boolean notQualified;

    private boolean signedIn;

    private String sequenceStatus;

    private String serviceQualsHex;

    private boolean deleted;

    private boolean isBlockedforIOE;

    private boolean isSuperNumerary;

    private int premiumInd;

    private int reassignmentNumber;

    private boolean hbtsequence;

    private String requiredLanguage;

    public boolean isMultipleEquipments() {
        return multipleEquipments;
    }

    public String getSequenceOriginDate() {
        return sequenceOriginDate;
    }

    public void setSequenceOriginDate(final String sequenceOriginDate) {
        this.sequenceOriginDate = sequenceOriginDate;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(final String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getBase() {
        return base;
    }

    public void setBase(final String base) {
        this.base = base;
    }

    public String getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(final String contractMonth) {
        this.contractMonth = contractMonth;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(final int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(final String positionCode) {
        this.positionCode = positionCode;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(final String division) {
        this.division = division;
    }

    public String getLandingQuals() {
        return landingQuals;
    }

    public void setLandingQuals(final String landingQuals) {
        this.landingQuals = landingQuals;
    }

    public boolean isLastSequencePayProtection() {
        return lastSequencePayProtection;
    }

    public void setLastSequencePayProtection(final boolean lastSequencePayProtection) {
        this.lastSequencePayProtection = lastSequencePayProtection;
    }

    public int getTotalOpenPositionsForSeq() {
        return totalOpenPositionsForSeq;
    }

    public void setTotalOpenPositionsForSeq(final int totalOpenPositionsForSeq) {
        this.totalOpenPositionsForSeq = totalOpenPositionsForSeq;
    }

    public int getTotalOpenPositionsForCabin() {
        return totalOpenPositionsForCabin;
    }

    public void setTotalOpenPositionsForCabin(final int totalOpenPositionsForCabin) {
        this.totalOpenPositionsForCabin = totalOpenPositionsForCabin;
    }

    public String getRemovalCode() {
        return removalCode;
    }

    public void setRemovalCode(final String removalCode) {
        this.removalCode = removalCode;
    }

    public boolean isNoShowDHD() {
        return noShowDHD;
    }

    public void setNoShowDHD(final boolean noShowDHD) {
        this.noShowDHD = noShowDHD;
    }

    public boolean isObservationTrip() {
        return observationTrip;
    }

    public void setObservationTrip(final boolean observationTrip) {
        this.observationTrip = observationTrip;
    }

    public boolean isTtInhibited() {
        return ttInhibited;
    }

    public void setTtInhibited(final boolean ttInhibited) {
        this.ttInhibited = ttInhibited;
    }

    public void setMultipleEquipments(final boolean multipleEquipments) {
        this.multipleEquipments = multipleEquipments;
    }

    public void setNotQualified(final boolean notQualified) {
        this.notQualified = notQualified;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(final int employeeID) {
        this.employeeID = employeeID;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(final int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public SequenceStartDateTime getSequenceStartDateTime() {
        return sequenceStartDateTime;
    }

    public void setSequenceStartDateTime(final SequenceStartDateTime sequenceStartDateTime) {
        this.sequenceStartDateTime = sequenceStartDateTime;
    }

    public SequenceEndDateTime getSequenceEndDateTime() {
        return sequenceEndDateTime;
    }

    public String getLegsPerDutyPeriod() {
        return legsPerDutyPeriod;
    }

    public void setLegsPerDutyPeriod(final String legsPerDutyPeriod) {
        this.legsPerDutyPeriod = legsPerDutyPeriod;
    }

    public String getFirstLegDepartureAirport() {
        return firstLegDepartureAirport;
    }

    public CCSDateTimeDTO getFirstLegDepartureTime() {
        return firstLegDepartureTime;
    }

    public void setFirstLegDepartureTime(final CCSDateTimeDTO firstLegDepartureTime) {
        this.firstLegDepartureTime = firstLegDepartureTime;
    }

    public String getAddCode() {
        return addCode;
    }

    public void setAddCode(final String addCode) {
        this.addCode = addCode;
    }

    public void setFirstLegDepartureAirport(final String firstLegDepartureAirport) {
        this.firstLegDepartureAirport = firstLegDepartureAirport;
    }

    public String getEquipmentGroup() {
        return equipmentGroup;
    }

    public void setEquipmentGroup(final String equipmentGroup) {
        this.equipmentGroup = equipmentGroup;
    }

    public int getCreditThisMonth() {
        return creditThisMonth;
    }

    public void setCreditThisMonth(final int creditThisMonth) {
        this.creditThisMonth = creditThisMonth;
    }

    public int getCreditNextMonth() {
        return creditNextMonth;
    }

    public void setCreditNextMonth(final int creditNextMonth) {
        this.creditNextMonth = creditNextMonth;
    }

    public int getScheduledFlight() {
        return scheduledFlight;
    }

    public void setScheduledFlight(final int scheduledFlight) {
        this.scheduledFlight = scheduledFlight;
    }

    public String getPositionSequenceInfo1() {
        return positionSequenceInfo1;
    }

    public void setPositionSequenceInfo1(final String positionSequenceInfo1) {
        this.positionSequenceInfo1 = positionSequenceInfo1;
    }

    public String getPositionSequenceInfo1Binary() {
        return positionSequenceInfo1Binary;
    }

    public void setPositionSequenceInfo1Binary(final String positionSequenceInfo1Binary) {
        this.positionSequenceInfo1Binary = positionSequenceInfo1Binary;
    }

    public String getPositionSequenceInfo2() {
        return positionSequenceInfo2;
    }

    public void setPositionSequenceInfo2(final String positionSequenceInfo2) {
        this.positionSequenceInfo2 = positionSequenceInfo2;
    }

    public List<FlightDutyPeriodDTO> getFlightDutyPeriods() {
        return flightDutyPeriods;
    }

    public void setFlightDutyPeriods(final List<FlightDutyPeriodDTO> flightDutyPeriod) {
        this.flightDutyPeriods = flightDutyPeriod;
    }

    public boolean getFailsContinuity() {
        return failsContinuity;
    }

    public void setFailsContinuity(final boolean failsContinuity) {
        this.failsContinuity = failsContinuity;
    }

    public boolean getGalleyPosition() {
        return galleyPosition;
    }

    public void setGalleyPosition(final boolean galleyPosition) {
        this.galleyPosition = galleyPosition;
    }

    public int getTotalLegCount() {
        return totalLegCount;
    }

    public void setTotalLegCount(final int totalLegCount) {
        this.totalLegCount = totalLegCount;
    }

    public int getSequenceBlockTime() {
        return sequenceBlockTime;
    }

    public void setSequenceBlockTime(final int sequenceBlockTime) {
        this.sequenceBlockTime = sequenceBlockTime;
    }

    public int getSequencePayTime() {
        return sequencePayTime;
    }

    public void setSequencePayTime(final int sequencePayTime) {
        this.sequencePayTime = sequencePayTime;
    }

    public boolean getInternational() {
        return international;
    }

    public void setInternational(final boolean international) {
        this.international = international;
    }

    public int getTimeAwayFromBase() {
        return timeAwayFromBase;
    }

    public void setTimeAwayFromBase(final int timeAwayFromBase) {
        this.timeAwayFromBase = timeAwayFromBase;
    }

    public List<ServiceQuals> getServiceQuals() {
        return serviceQuals;
    }

    public void setServiceQuals(final List<ServiceQuals> serviceQuals) {
        this.serviceQuals = serviceQuals;
    }

    public String getSignInTimeBase() {
        return signInTimeBase;
    }

    public void setSignInTimeBase(final String signInTimeBase) {
        this.signInTimeBase = signInTimeBase;
    }

    public String getSignInTimeInGMT() {
        return signInTimeInGMT;
    }

    public void setSignInTimeInGMT(final String signInTimeInGMT) {
        this.signInTimeInGMT = signInTimeInGMT;
    }

    public String getSequenceDutyTime() {
        return sequenceDutyTime;
    }

    public void setSequenceDutyTime(final String sequenceDutyTime) {
        this.sequenceDutyTime = sequenceDutyTime;
    }

    public void setSequenceEndDateTime(final SequenceEndDateTime sequenceEndDateTime) {
        this.sequenceEndDateTime = sequenceEndDateTime;
    }

    public boolean getIsSatellite() {
        return isSatellite;
    }

    public void setIsSatellite(final boolean isSatellite) {
        this.isSatellite = isSatellite;
    }

    public boolean getIsCoterminal() {
        return isCoterminal;
    }

    public void setIsCoterminal(final boolean isCoterminal) {
        this.isCoterminal = isCoterminal;
    }

    public boolean getIsIPD() {
        return isIPD;
    }

    public void setIsIPD(final boolean isIPD) {
        this.isIPD = isIPD;
    }

    public boolean getIsODAN() {
        return isODAN;
    }

    public void setIsODAN(final boolean isODAN) {
        this.isODAN = isODAN;
    }

    public boolean getIsRedEye() {
        return isRedEye;
    }

    public void setIsRedEye(final boolean isRedEye) {
        this.isRedEye = isRedEye;
    }

    public boolean getIsRedFlag() {
        return isRedFlag;
    }

    public void setIsRedFlag(final boolean isRedFlag) {
        this.isRedFlag = isRedFlag;
    }

    public boolean getIsTrainingSequence() {
        return isTrainingSequence;
    }

    public String getTimeOpened() {
        return timeOpened;
    }

    public void setTimeOpened(final String timeOpened) {
        this.timeOpened = timeOpened;
    }

    public void setIsTrainingSequence(final boolean isTrainingSequence) {
        this.isTrainingSequence = isTrainingSequence;
    }

    public boolean getFirstLegDeadHeadIndicator() {
        return firstLegDeadHeadIndicator;
    }

    public void setFirstLegDeadHeadIndicator(final boolean firstLegDeadHeadIndicator) {
        this.firstLegDeadHeadIndicator = firstLegDeadHeadIndicator;
    }

    public boolean getLastLegDeadHeadIndicator() {
        return lastLegDeadHeadIndicator;
    }

    public void setLastLegDeadHeadIndicator(final boolean lastLegDeadHeadIndicator) {
        this.lastLegDeadHeadIndicator = lastLegDeadHeadIndicator;
    }

    public boolean isPurser() {
        return purser;
    }

    public void setPurser(final boolean purser) {
        this.purser = purser;
    }

    // @Override
    // public int compareTo(SequenceInfoKeyResponse o) {
    //// if (this.sequenceNumber == o.getSequenceNumber()) {
    //// return 0;
    //// }
    //// return this.sequenceNumber > o.getSequenceNumber() ? 1 : -1;
    //
    // return this.sequenceNumber - o.getSequenceNumber();
    // }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }

    public void setSatellite(final boolean isSatellite) {
        this.isSatellite = isSatellite;
    }

    public void setCoterminal(final boolean isCoterminal) {
        this.isCoterminal = isCoterminal;
    }

    public void setIPD(final boolean isIPD) {
        this.isIPD = isIPD;
    }

    public void setODAN(final boolean isODAN) {
        this.isODAN = isODAN;
    }

    public void setRedEye(final boolean isRedEye) {
        this.isRedEye = isRedEye;
    }

    public void setRedFlag(final boolean isRedFlag) {
        this.isRedFlag = isRedFlag;
    }

    public boolean isNotQualified() {
        return notQualified;
    }

    public void setTrainingSequence(final boolean isTrainingSequence) {
        this.isTrainingSequence = isTrainingSequence;
    }

    public SpeakerRequirement getSpeakerRequirement() {
        return speakerRequirement;
    }

    public void setSpeakerRequirement(final SpeakerRequirement speakerRequirement) {
        this.speakerRequirement = speakerRequirement;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(final int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public SequencePayCredit getSequencePayCredit() {
        return sequencePayCredit;
    }

    public void setSequencePayCredit(final SequencePayCredit sequencePayCredit) {
        this.sequencePayCredit = sequencePayCredit;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    public void setSignedIn(final boolean signedIn) {
        this.signedIn = signedIn;
    }

    public String getSequenceStatus() {
        return sequenceStatus;
    }

    public void setSequenceStatus(final String sequenceStatus) {
        this.sequenceStatus = sequenceStatus;
    }

    public String getServiceQualsHex() {
        return serviceQualsHex;
    }

    public void setServiceQualsHex(final String serviceQualsHex) {
        this.serviceQualsHex = serviceQualsHex;
    }

    public boolean isBlockedforIOE() {
        return isBlockedforIOE;
    }

    public void setBlockedforIOE(final boolean isBlockedforIOE) {
        this.isBlockedforIOE = isBlockedforIOE;
    }

    public boolean isSuperNumerary() {
        return isSuperNumerary;
    }

    public void setSuperNumerary(final boolean isSuperNumerary) {
        this.isSuperNumerary = isSuperNumerary;
    }

    public int getPremiumInd() {
        return premiumInd;
    }

    public void setPremiumInd(final int premiumInd) {
        this.premiumInd = premiumInd;
    }

    public int getReassignmentNumber() {
        return reassignmentNumber;
    }

    public void setReassignmentNumber(final int reassignmentNumber) {
        this.reassignmentNumber = reassignmentNumber;
    }

    public boolean isHbtsequence() {
        return hbtsequence;
    }

    public void setHbtsequence(final boolean hbtsequence) {
        this.hbtsequence = hbtsequence;
    }

    public String getLastLegArrivalAirport() {
        return lastLegArrivalAirport;
    }

    public void setLastLegArrivalAirport(final String lastLegArrivalAirport) {
        this.lastLegArrivalAirport = lastLegArrivalAirport;
    }

    public boolean isAssignedStandbyShift() {
        return assignedStandbyShift;
    }

    public void setAssignedStandbyShift(final boolean assignedStandbyShift) {
        this.assignedStandbyShift = assignedStandbyShift;
    }

    public boolean isAwardedStandbyShift() {
        return awardedStandbyShift;
    }

    public void setAwardedStandbyShift(final boolean awardedStandbyShift) {
        this.awardedStandbyShift = awardedStandbyShift;
    }

    public LastLegArrivalTime getLastLegArrivalTime() {
        return lastLegArrivalTime;
    }

    public void setLastLegArrivalTime(final LastLegArrivalTime lastLegArrivalTime) {
        this.lastLegArrivalTime = lastLegArrivalTime;
    }

    @Override
    public String toString() {
        return "SequenceInfoKeyResponse [airlineCode=" + airlineCode + ", base=" + base + ", contractMonth="
                + contractMonth + ", sequenceOriginDate=" + sequenceOriginDate + ", sequenceNumber=" + sequenceNumber
                + ", positionCode=" + positionCode + ", division=" + division + ", employeeID=" + employeeID
                + ", durationInDays=" + durationInDays + ", sequenceStartDateTime=" + sequenceStartDateTime
                + ", sequenceEndDateTime=" + sequenceEndDateTime + ", legsPerDutyPeriod=" + legsPerDutyPeriod
                + ", numberOfLegs=" + numberOfLegs + ", firstLegDepartureTime=" + firstLegDepartureTime
                + ", firstLegDepartureAirport=" + firstLegDepartureAirport + ", landingQuals=" + landingQuals
                + ", equipmentGroup=" + equipmentGroup + ", creditThisMonth=" + creditThisMonth + ", creditNextMonth="
                + creditNextMonth + ", scheduledFlight=" + scheduledFlight + ", positionSequenceInfo1="
                + positionSequenceInfo1 + ", positionSequenceInfo1Binary=" + positionSequenceInfo1Binary
                + ", positionSequenceInfo2=" + positionSequenceInfo2 + ", assignedStandbyShift=" + assignedStandbyShift
                + ", awardedStandbyShift=" + awardedStandbyShift + ", lastSequencePayProtection="
                + lastSequencePayProtection + ", flightDutyPeriods=" + flightDutyPeriods + ", speakerRequirement="
                + speakerRequirement + ", failsContinuity=" + failsContinuity + ", galleyPosition=" + galleyPosition
                + ", totalLegCount=" + totalLegCount + ", sequencePayCredit=" + sequencePayCredit
                + ", sequenceBlockTime=" + sequenceBlockTime + ", sequencePayTime=" + sequencePayTime
                + ", international=" + international + ", timeAwayFromBase=" + timeAwayFromBase + ", isSatellite="
                + isSatellite + ", isCoterminal=" + isCoterminal + ", isIPD=" + isIPD + ", isODAN=" + isODAN
                + ", isRedEye=" + isRedEye + ", isRedFlag=" + isRedFlag + ", isTrainingSequence=" + isTrainingSequence
                + ", firstLegDeadHeadIndicator=" + firstLegDeadHeadIndicator + ", lastLegDeadHeadIndicator="
                + lastLegDeadHeadIndicator + ", lastLegArrivalAirport=" + lastLegArrivalAirport
                + ", lastLegArrivalTime=" + lastLegArrivalTime + ", timeOpened=" + timeOpened
                + ", totalOpenPositionsForSeq=" + totalOpenPositionsForSeq + ", totalOpenPositionsForCabin="
                + totalOpenPositionsForCabin + ", removalCode=" + removalCode + ", multipleEquipments="
                + multipleEquipments + ", noShowDHD=" + noShowDHD + ", observationTrip=" + observationTrip
                + ", ttInhibited=" + ttInhibited + ", purser=" + purser + ", notQualified=" + notQualified
                + ", signedIn=" + signedIn + ", sequenceStatus=" + sequenceStatus + ", serviceQualsHex="
                + serviceQualsHex + ", deleted=" + deleted + ", isBlockedforIOE=" + isBlockedforIOE
                + ", isSuperNumerary=" + isSuperNumerary + ", premiumInd=" + premiumInd + ", reassignmentNumber="
                + reassignmentNumber + ", hbtsequence=" + hbtsequence + "]";
    }

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(final String cabinType) {
        this.cabinType = cabinType;
    }

    public String getLayoverStations() {
        return layoverStations;
    }

    public void setLayoverStations(final String layoverStations) {
        this.layoverStations = layoverStations;
    }

    public String getRequiredLanguage() {
        return requiredLanguage;
    }

    public void setRequiredLanguage(final String requiredLanguage) {
        this.requiredLanguage = requiredLanguage;
    }

    public boolean isNIPD() {
        return isNIPD;
    }

    public void setNIPD(final boolean isNIPD) {
        this.isNIPD = isNIPD;
    }

}
