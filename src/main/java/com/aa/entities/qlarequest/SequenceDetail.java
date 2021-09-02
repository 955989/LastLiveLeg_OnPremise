/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

import java.util.List;

public class SequenceDetail {
	private Object addCode;
	private String base;
	private String cabinType;
	private boolean coterminal;
	private String divisionType;
	private DutyPeriods dutyPeriods;
	private String endDateTime;
	private String endDateTimeInBaseTime;
	private String endDateTimeInGmt;
	private List<String> equipmentGroups;
	private boolean firstLegDHD;
	private String firstLegDepAirport;
	private FlightLegs flightLegs;
	private boolean galleyPosition;
	private boolean international;
	private boolean ipd;
	private String landingQuals;
	private List<LanguageRequirement> languageRequirements;
	private String lastLegArrivalAirport;
	private boolean lastLegDHD;
	private boolean nipd;
	private boolean odan;
	private String posLangQual;
	private boolean posSpeakerRestricted;
	private boolean purser;
	private boolean redEye;
	private boolean satellite;
	private SeqProperties seqProperties;
	private SequenceInfoKey sequenceInfoKey;
	private SequencePayCredit sequencePayCredit;
	private String sequenceStatus;
	private String startDateTime;
	private String startDateTimeInBaseTime;
	private String startDateTimeInGmt;
	private int totalMissingForCabin;
	private int totalMissingForSeq;
	private int totalOpenPositionsForCabin;
	private int totalOpenPositionsForSeq;
	private int totalRequiredForCabin;
	private int totalRequiredForSeq;
	private String type;
	private int creditThisMonth;

	public Object getAddCode() {
		return addCode;
	}

	public void setAddCode(Object addCode) {
		this.addCode = addCode;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getCabinType() {
		return cabinType;
	}

	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

	public boolean isCoterminal() {
		return coterminal;
	}

	public void setCoterminal(boolean coterminal) {
		this.coterminal = coterminal;
	}

	public String getDivisionType() {
		return divisionType;
	}

	public void setDivisionType(String divisionType) {
		this.divisionType = divisionType;
	}

	public DutyPeriods getDutyPeriods() {
		return dutyPeriods;
	}

	public void setDutyPeriods(DutyPeriods dutyPeriods) {
		this.dutyPeriods = dutyPeriods;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getEndDateTimeInBaseTime() {
		return endDateTimeInBaseTime;
	}

	public void setEndDateTimeInBaseTime(String endDateTimeInBaseTime) {
		this.endDateTimeInBaseTime = endDateTimeInBaseTime;
	}

	public String getEndDateTimeInGmt() {
		return endDateTimeInGmt;
	}

	public void setEndDateTimeInGmt(String endDateTimeInGmt) {
		this.endDateTimeInGmt = endDateTimeInGmt;
	}

	public List<String> getEquipmentGroups() {
		return equipmentGroups;
	}

	public void setEquipmentGroups(List<String> equipmentGroups) {
		this.equipmentGroups = equipmentGroups;
	}

	public boolean isFirstLegDHD() {
		return firstLegDHD;
	}

	public void setFirstLegDHD(boolean firstLegDHD) {
		this.firstLegDHD = firstLegDHD;
	}

	public String getFirstLegDepAirport() {
		return firstLegDepAirport;
	}

	public void setFirstLegDepAirport(String firstLegDepAirport) {
		this.firstLegDepAirport = firstLegDepAirport;
	}

	public FlightLegs getFlightLegs() {
		return flightLegs;
	}

	public void setFlightLegs(FlightLegs flightLegs) {
		this.flightLegs = flightLegs;
	}

	public boolean isGalleyPosition() {
		return galleyPosition;
	}

	public void setGalleyPosition(boolean galleyPosition) {
		this.galleyPosition = galleyPosition;
	}

	public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public boolean isIpd() {
		return ipd;
	}

	public void setIpd(boolean ipd) {
		this.ipd = ipd;
	}

	public String getLandingQuals() {
		return landingQuals;
	}

	public void setLandingQuals(String landingQuals) {
		this.landingQuals = landingQuals;
	}

	public List<LanguageRequirement> getLanguageRequirements() {
		return languageRequirements;
	}

	public void setLanguageRequirements(List<LanguageRequirement> languageRequirements) {
		this.languageRequirements = languageRequirements;
	}

	public String getLastLegArrivalAirport() {
		return lastLegArrivalAirport;
	}

	public void setLastLegArrivalAirport(String lastLegArrivalAirport) {
		this.lastLegArrivalAirport = lastLegArrivalAirport;
	}

	public boolean isLastLegDHD() {
		return lastLegDHD;
	}

	public void setLastLegDHD(boolean lastLegDHD) {
		this.lastLegDHD = lastLegDHD;
	}

	public boolean isNipd() {
		return nipd;
	}

	public void setNipd(boolean nipd) {
		this.nipd = nipd;
	}

	public boolean isOdan() {
		return odan;
	}

	public void setOdan(boolean odan) {
		this.odan = odan;
	}

	public String getPosLangQual() {
		return posLangQual;
	}

	public void setPosLangQual(String posLangQual) {
		this.posLangQual = posLangQual;
	}

	public boolean isPosSpeakerRestricted() {
		return posSpeakerRestricted;
	}

	public void setPosSpeakerRestricted(boolean posSpeakerRestricted) {
		this.posSpeakerRestricted = posSpeakerRestricted;
	}

	public boolean isPurser() {
		return purser;
	}

	public void setPurser(boolean purser) {
		this.purser = purser;
	}

	public boolean isRedEye() {
		return redEye;
	}

	public void setRedEye(boolean redEye) {
		this.redEye = redEye;
	}

	public boolean isSatellite() {
		return satellite;
	}

	public void setSatellite(boolean satellite) {
		this.satellite = satellite;
	}

	public SeqProperties getSeqProperties() {
		return seqProperties;
	}

	public void setSeqProperties(SeqProperties seqProperties) {
		this.seqProperties = seqProperties;
	}

	public SequenceInfoKey getSequenceInfoKey() {
		return sequenceInfoKey;
	}

	public void setSequenceInfoKey(SequenceInfoKey sequenceInfoKey) {
		this.sequenceInfoKey = sequenceInfoKey;
	}

	public SequencePayCredit getSequencePayCredit() {
		return sequencePayCredit;
	}

	public void setSequencePayCredit(SequencePayCredit sequencePayCredit) {
		this.sequencePayCredit = sequencePayCredit;
	}

	public String getSequenceStatus() {
		return sequenceStatus;
	}

	public void setSequenceStatus(String sequenceStatus) {
		this.sequenceStatus = sequenceStatus;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getStartDateTimeInBaseTime() {
		return startDateTimeInBaseTime;
	}

	public void setStartDateTimeInBaseTime(String startDateTimeInBaseTime) {
		this.startDateTimeInBaseTime = startDateTimeInBaseTime;
	}

	public String getStartDateTimeInGmt() {
		return startDateTimeInGmt;
	}

	public void setStartDateTimeInGmt(String startDateTimeInGmt) {
		this.startDateTimeInGmt = startDateTimeInGmt;
	}

	public int getTotalMissingForCabin() {
		return totalMissingForCabin;
	}

	public void setTotalMissingForCabin(int totalMissingForCabin) {
		this.totalMissingForCabin = totalMissingForCabin;
	}

	public int getTotalMissingForSeq() {
		return totalMissingForSeq;
	}

	public void setTotalMissingForSeq(int totalMissingForSeq) {
		this.totalMissingForSeq = totalMissingForSeq;
	}

	public int getTotalOpenPositionsForCabin() {
		return totalOpenPositionsForCabin;
	}

	public void setTotalOpenPositionsForCabin(int totalOpenPositionsForCabin) {
		this.totalOpenPositionsForCabin = totalOpenPositionsForCabin;
	}

	public int getTotalOpenPositionsForSeq() {
		return totalOpenPositionsForSeq;
	}

	public void setTotalOpenPositionsForSeq(int totalOpenPositionsForSeq) {
		this.totalOpenPositionsForSeq = totalOpenPositionsForSeq;
	}

	public int getTotalRequiredForCabin() {
		return totalRequiredForCabin;
	}

	public void setTotalRequiredForCabin(int totalRequiredForCabin) {
		this.totalRequiredForCabin = totalRequiredForCabin;
	}

	public int getTotalRequiredForSeq() {
		return totalRequiredForSeq;
	}

	public void setTotalRequiredForSeq(int totalRequiredForSeq) {
		this.totalRequiredForSeq = totalRequiredForSeq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCreditThisMonth() {
		return creditThisMonth;
	}

	public void setCreditThisMonth(int creditThisMonth) {
		this.creditThisMonth = creditThisMonth;
	}

	@Override
	public String toString() {
		return "SequenceDetail [addCode=" + addCode + ", base=" + base + ", cabinType=" + cabinType + ", coterminal="
				+ coterminal + ", divisionType=" + divisionType + ", dutyPeriods=" + dutyPeriods + ", endDateTime="
				+ endDateTime + ", endDateTimeInBaseTime=" + endDateTimeInBaseTime + ", endDateTimeInGmt="
				+ endDateTimeInGmt + ", equipmentGroups=" + equipmentGroups + ", firstLegDHD=" + firstLegDHD
				+ ", firstLegDepAirport=" + firstLegDepAirport + ", flightLegs=" + flightLegs + ", galleyPosition="
				+ galleyPosition + ", international=" + international + ", ipd=" + ipd + ", landingQuals="
				+ landingQuals + ", languageRequirements=" + languageRequirements + ", lastLegArrivalAirport="
				+ lastLegArrivalAirport + ", lastLegDHD=" + lastLegDHD + ", nipd=" + nipd + ", odan=" + odan
				+ ", posLangQual=" + posLangQual + ", posSpeakerRestricted=" + posSpeakerRestricted + ", purser="
				+ purser + ", redEye=" + redEye + ", satellite=" + satellite + ", seqProperties=" + seqProperties
				+ ", sequenceInfoKey=" + sequenceInfoKey + ", sequencePayCredit=" + sequencePayCredit
				+ ", sequenceStatus=" + sequenceStatus + ", startDateTime=" + startDateTime
				+ ", startDateTimeInBaseTime=" + startDateTimeInBaseTime + ", startDateTimeInGmt=" + startDateTimeInGmt
				+ ", totalMissingForCabin=" + totalMissingForCabin + ", totalMissingForSeq=" + totalMissingForSeq
				+ ", totalOpenPositionsForCabin=" + totalOpenPositionsForCabin + ", totalOpenPositionsForSeq="
				+ totalOpenPositionsForSeq + ", totalRequiredForCabin=" + totalRequiredForCabin
				+ ", totalRequiredForSeq=" + totalRequiredForSeq + ", type=" + type + ", creditThisMonth="
				+ creditThisMonth + "]";
	}

}
