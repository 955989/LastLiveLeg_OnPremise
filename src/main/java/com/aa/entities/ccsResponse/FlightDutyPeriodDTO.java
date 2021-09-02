/**
 * @author rswami
 * POJO to get flight duty period from CCS service
 **/

package com.aa.entities.ccsResponse;

/* Developed by RitikaSwami
* This file has POJO to get Sequence details from CCS service
*/

import java.util.List;

public class FlightDutyPeriodDTO  {

    private CCSDateTimeDTO startDateTime;

    private int dutyPeriodNumber;

    private CCSDateTimeDTO endDateTime;

	private int odMinutes;

    private int numberOfLegs;

    private String layOverAirport;

	private int duration;

    private String layoverStation;

    private int layoverInMinutes;

    private boolean crewMeal;

    private List<FlightLegDTO> flightLegs;

    private PayCreditDTO payCredit;
    
    private String dutyPeriodStatus;

    private boolean odan;
    
    private boolean redEye;
    
    private boolean hawaiiDutyPeriod;
    
    private boolean mediumRangeDP;
    
    private boolean nonLongRangeDP;
    
    private boolean domesticDP;
    
    private boolean ipdDP;
    
    private int fdpDuration;
    
    private int fdpAcclimatedStnTZAdjustment;
    
    public String getDutyPeriodStatus() {
		return dutyPeriodStatus;
	}

	public void setDutyPeriodStatus(String dutyPeriodStatus) {
		this.dutyPeriodStatus = dutyPeriodStatus;
	}

	public boolean isOdan() {
		return odan;
	}

	public void setOdan(boolean odan) {
		this.odan = odan;
	}

	public boolean isRedEye() {
		return redEye;
	}

	public void setRedEye(boolean redEye) {
		this.redEye = redEye;
	}

	public boolean isHawaiiDutyPeriod() {
		return hawaiiDutyPeriod;
	}

	public void setHawaiiDutyPeriod(boolean hawaiiDutyPeriod) {
		this.hawaiiDutyPeriod = hawaiiDutyPeriod;
	}

	public boolean isMediumRangeDP() {
		return mediumRangeDP;
	}

	public void setMediumRangeDP(boolean mediumRangeDP) {
		this.mediumRangeDP = mediumRangeDP;
	}

	public boolean isNonLongRangeDP() {
		return nonLongRangeDP;
	}

	public void setNonLongRangeDP(boolean nonLongRangeDP) {
		this.nonLongRangeDP = nonLongRangeDP;
	}

	public boolean isDomesticDP() {
		return domesticDP;
	}

	public void setDomesticDP(boolean domesticDP) {
		this.domesticDP = domesticDP;
	}

	public boolean isIpdDP() {
		return ipdDP;
	}

	public void setIpdDP(boolean ipdDP) {
		this.ipdDP = ipdDP;
	}

	public int getFdpDuration() {
		return fdpDuration;
	}

	public void setFdpDuration(int fdpDuration) {
		this.fdpDuration = fdpDuration;
	}

	public int getFdpAcclimatedStnTZAdjustment() {
		return fdpAcclimatedStnTZAdjustment;
	}

	public void setFdpAcclimatedStnTZAdjustment(int fdpAcclimatedStnTZAdjustment) {
		this.fdpAcclimatedStnTZAdjustment = fdpAcclimatedStnTZAdjustment;
	}

	
	
	

	public String getLayoverStation() {
        return layoverStation;
    }

    public void setLayoverStation(final String layoverStation) {
        this.layoverStation = layoverStation;
    }

    public int getLayoverInMinutes() {
        return layoverInMinutes;
    }

    public void setLayoverInMinutes(final int layoverInMinutes) {
        this.layoverInMinutes = layoverInMinutes;
    }

//    public boolean getCrewMeal() {
//        return crewMeal;
//    }
//
//    public void setCrewMeal(final boolean crewMeal) {
//        this.crewMeal = crewMeal;
//    }

    public int getDutyPeriodNumber() {
        return dutyPeriodNumber;
    }

    public void setDutyPeriodNumber(final int dutyPeriodNumber) {
        this.dutyPeriodNumber = dutyPeriodNumber;
    }

    public CCSDateTimeDTO getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(final CCSDateTimeDTO startDateTime) {
        this.startDateTime = startDateTime;
    }

    public CCSDateTimeDTO getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(final CCSDateTimeDTO endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getOdMinutes() {
        return odMinutes;
    }

    public void setOdMinutes(final int odMinutes) {
        this.odMinutes = odMinutes;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(final int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getLayOverAirport() {
        return layOverAirport;
    }

    public void setLayOverAirport(final String layOverAirport) {
        this.layOverAirport = layOverAirport;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public List<FlightLegDTO> getFlightLegs() {
        return flightLegs;
    }

    public void setFlightLegs(final List<FlightLegDTO> flightLegs) {
        this.flightLegs = flightLegs;
    }

    public PayCreditDTO getPayCredit() {
        return payCredit;
    }

    public void setPayCredit(final PayCreditDTO payCredit) {
        this.payCredit = payCredit;
    }
    
    public boolean isCrewMeal() {
		return crewMeal;
	}

	public void setCrewMeal(boolean crewMeal) {
		this.crewMeal = crewMeal;
	}
    
    @Override
	public String toString() {
		return "FlightDutyPeriodDTO [startDateTime=" + startDateTime + ", dutyPeriodNumber=" + dutyPeriodNumber
				+ ", endDateTime=" + endDateTime + ", odMinutes=" + odMinutes + ", numberOfLegs=" + numberOfLegs
				+ ", layOverAirport=" + layOverAirport + ", duration=" + duration + ", layoverStation=" + layoverStation
				+ ", layoverInMinutes=" + layoverInMinutes + ", crewMeal=" + crewMeal + ", flightLegs=" + flightLegs
				+ ", payCredit=" + payCredit + ", dutyPeriodStatus=" + dutyPeriodStatus + ", odan=" + odan + ", redEye="
				+ redEye + ", hawaiiDutyPeriod=" + hawaiiDutyPeriod + ", mediumRangeDP=" + mediumRangeDP
				+ ", nonLongRangeDP=" + nonLongRangeDP + ", domesticDP=" + domesticDP + ", ipdDP=" + ipdDP
				+ ", fdpDuration=" + fdpDuration + ", fdpAcclimatedStnTZAdjustment=" + fdpAcclimatedStnTZAdjustment
				+ "]";
	}
    

}