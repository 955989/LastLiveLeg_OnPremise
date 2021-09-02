/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

public class Add {
	private NormalFlightLeg normalFlightLeg;
	private Object indicatePosAtHO;
	private Object twoHrMinCreditALL;
	private Object twoHrMinCreditIndiv;
	private Object surfaceTransportation;
	private ReportLeg reportLeg;
	private Object miscOrTraining;
	private Object replyId;
	private Object oaldeadHead;
	private String value;
	private String status;

	public NormalFlightLeg getNormalFlightLeg() {
		return normalFlightLeg;
	}

	public void setNormalFlightLeg(NormalFlightLeg normalFlightLeg) {
		this.normalFlightLeg = normalFlightLeg;
	}

	public Object getIndicatePosAtHO() {
		return indicatePosAtHO;
	}

	public void setIndicatePosAtHO(Object indicatePosAtHO) {
		this.indicatePosAtHO = indicatePosAtHO;
	}

	public Object getTwoHrMinCreditALL() {
		return twoHrMinCreditALL;
	}

	public void setTwoHrMinCreditALL(Object twoHrMinCreditALL) {
		this.twoHrMinCreditALL = twoHrMinCreditALL;
	}

	public Object getTwoHrMinCreditIndiv() {
		return twoHrMinCreditIndiv;
	}

	public void setTwoHrMinCreditIndiv(Object twoHrMinCreditIndiv) {
		this.twoHrMinCreditIndiv = twoHrMinCreditIndiv;
	}

	public Object getSurfaceTransportation() {
		return surfaceTransportation;
	}

	public void setSurfaceTransportation(Object surfaceTransportation) {
		this.surfaceTransportation = surfaceTransportation;
	}

	public ReportLeg getReportLeg() {
		return reportLeg;
	}

	public void setReportLeg(ReportLeg reportLeg) {
		this.reportLeg = reportLeg;
	}

	public Object getMiscOrTraining() {
		return miscOrTraining;
	}

	public void setMiscOrTraining(Object miscOrTraining) {
		this.miscOrTraining = miscOrTraining;
	}

	public Object getReplyId() {
		return replyId;
	}

	public void setReplyId(Object replyId) {
		this.replyId = replyId;
	}

	public Object getOaldeadHead() {
		return oaldeadHead;
	}

	public void setOaldeadHead(Object oaldeadHead) {
		this.oaldeadHead = oaldeadHead;
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
		return "Add [normalFlightLeg=" + normalFlightLeg + ", indicatePosAtHO=" + indicatePosAtHO
				+ ", twoHrMinCreditALL=" + twoHrMinCreditALL + ", twoHrMinCreditIndiv=" + twoHrMinCreditIndiv
				+ ", surfaceTransportation=" + surfaceTransportation + ", reportLeg=" + reportLeg + ", miscOrTraining="
				+ miscOrTraining + ", replyId=" + replyId + ", oaldeadHead=" + oaldeadHead + ", value=" + value
				+ ", status=" + status + "]";
	}

}