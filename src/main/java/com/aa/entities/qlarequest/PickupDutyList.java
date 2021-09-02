/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class PickupDutyList {
	private int activityId;
	private String activityOriginationDate;
	private String activityType;
	private String airlineCode;
	private String contractMonth;
	private String positionCode;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityOriginationDate() {
		return activityOriginationDate;
	}

	public void setActivityOriginationDate(String activityOriginationDate) {
		this.activityOriginationDate = activityOriginationDate;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	@Override
	public String toString() {
		return "PickupDutyList [activityId=" + activityId + ", activityOriginationDate=" + activityOriginationDate
				+ ", activityType=" + activityType + ", airlineCode=" + airlineCode + ", contractMonth=" + contractMonth
				+ ", positionCode=" + positionCode + "]";
	}

	public String getContractMonth() {
		return contractMonth;
	}

	public void setContractMonth(String contractMonth) {
		this.contractMonth = contractMonth;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

}
