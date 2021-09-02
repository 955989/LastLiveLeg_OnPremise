/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class DutyPeriodItem {

	private ActualEndDateTime actualEndDateTime;
	private ActualStartDateTime actualStartDateTime;
	private DutyPeriodIndicators dutyPeriodIndicators;
	private String dutyPeriodStatus;
	private FdpEndTime fdpEndTime;
	private FdpStartTime fdpStartTime;
	private FlightDutyPeriodKey flightDutyPeriodKey;
	private boolean hawaiiDutyPeriod;
	private String scheduledEndDateTime;
	private String scheduledStartDateTime;

	public ActualEndDateTime getActualEndDateTime() {
		return actualEndDateTime;
	}

	public void setActualEndDateTime(ActualEndDateTime actualEndDateTime) {
		this.actualEndDateTime = actualEndDateTime;
	}

	public ActualStartDateTime getActualStartDateTime() {
		return actualStartDateTime;
	}

	public void setActualStartDateTime(ActualStartDateTime actualStartDateTime) {
		this.actualStartDateTime = actualStartDateTime;
	}

	public DutyPeriodIndicators getDutyPeriodIndicators() {
		return dutyPeriodIndicators;
	}

	public void setDutyPeriodIndicators(DutyPeriodIndicators dutyPeriodIndicators) {
		this.dutyPeriodIndicators = dutyPeriodIndicators;
	}

	public String getDutyPeriodStatus() {
		return dutyPeriodStatus;
	}

	public void setDutyPeriodStatus(String dutyPeriodStatus) {
		this.dutyPeriodStatus = dutyPeriodStatus;
	}

	public FdpEndTime getFdpEndTime() {
		return fdpEndTime;
	}

	public void setFdpEndTime(FdpEndTime fdpEndTime) {
		this.fdpEndTime = fdpEndTime;
	}

	public FdpStartTime getFdpStartTime() {
		return fdpStartTime;
	}

	public void setFdpStartTime(FdpStartTime fdpStartTime) {
		this.fdpStartTime = fdpStartTime;
	}

	public FlightDutyPeriodKey getFlightDutyPeriodKey() {
		return flightDutyPeriodKey;
	}

	public void setFlightDutyPeriodKey(FlightDutyPeriodKey flightDutyPeriodKey) {
		this.flightDutyPeriodKey = flightDutyPeriodKey;
	}

	public boolean isHawaiiDutyPeriod() {
		return hawaiiDutyPeriod;
	}

	public void setHawaiiDutyPeriod(boolean hawaiiDutyPeriod) {
		this.hawaiiDutyPeriod = hawaiiDutyPeriod;
	}

	public String getScheduledEndDateTime() {
		return scheduledEndDateTime;
	}

	public void setScheduledEndDateTime(String scheduledEndDateTime) {
		this.scheduledEndDateTime = scheduledEndDateTime;
	}

	public String getScheduledStartDateTime() {
		return scheduledStartDateTime;
	}

	public void setScheduledStartDateTime(String scheduledStartDateTime) {
		this.scheduledStartDateTime = scheduledStartDateTime;
	}

}
