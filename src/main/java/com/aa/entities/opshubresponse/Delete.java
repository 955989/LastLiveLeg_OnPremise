/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

public class Delete {

	private NormalFlightLeg normalFlightLeg;
	private Object flightLeg;
	private Object surfaceTransportationLeg;
	private Object reportLeg;
	private Object miscOrTraining;
	private Object allFromFlightLeg;
	private Object replyId;
	private Object oaldeadHeadFltLeg;
	private String value;
	private String status;

	public NormalFlightLeg getNormalFlightLeg() {
		return normalFlightLeg;
	}

	public void setNormalFlightLeg(NormalFlightLeg normalFlightLeg) {
		this.normalFlightLeg = normalFlightLeg;
	}

	public Object getFlightLeg() {
		return flightLeg;
	}

	public void setFlightLeg(Object flightLeg) {
		this.flightLeg = flightLeg;
	}

	public Object getSurfaceTransportationLeg() {
		return surfaceTransportationLeg;
	}

	public void setSurfaceTransportationLeg(Object surfaceTransportationLeg) {
		this.surfaceTransportationLeg = surfaceTransportationLeg;
	}

	public Object getReportLeg() {
		return reportLeg;
	}

	public void setReportLeg(Object reportLeg) {
		this.reportLeg = reportLeg;
	}

	public Object getMiscOrTraining() {
		return miscOrTraining;
	}

	public void setMiscOrTraining(Object miscOrTraining) {
		this.miscOrTraining = miscOrTraining;
	}

	public Object getAllFromFlightLeg() {
		return allFromFlightLeg;
	}

	public void setAllFromFlightLeg(Object allFromFlightLeg) {
		this.allFromFlightLeg = allFromFlightLeg;
	}

	public Object getReplyId() {
		return replyId;
	}

	public void setReplyId(Object replyId) {
		this.replyId = replyId;
	}

	public Object getOaldeadHeadFltLeg() {
		return oaldeadHeadFltLeg;
	}

	public void setOaldeadHeadFltLeg(Object oaldeadHeadFltLeg) {
		this.oaldeadHeadFltLeg = oaldeadHeadFltLeg;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Delete [normalFlightLeg=" + normalFlightLeg + ", flightLeg=" + flightLeg + ", surfaceTransportationLeg="
				+ surfaceTransportationLeg + ", reportLeg=" + reportLeg + ", miscOrTraining=" + miscOrTraining
				+ ", allFromFlightLeg=" + allFromFlightLeg + ", replyId=" + replyId + ", oaldeadHeadFltLeg="
				+ oaldeadHeadFltLeg + ", value=" + value + ", status=" + status + "]";
	}

}
