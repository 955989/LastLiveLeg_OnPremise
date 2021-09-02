
/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

public class Add {

	private Object normalFlightLeg;
	private Object indicatePosAtHO;
	private Object twoHrMinCreditALL;
	private Object twoHrMinCreditIndiv;
	private Object surfaceTransportation;
	private Object reportLeg;
	private Object miscOrTraining;
	private Object replyId;
	private OaldeadHead oaldeadHead;
	private String value;
	private String status;

	public Object getNormalFlightLeg() {
		return normalFlightLeg;
	}

	public void setNormalFlightLeg(Object normalFlightLeg) {
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

	public Object getReplyId() {
		return replyId;
	}

	public void setReplyId(Object replyId) {
		this.replyId = replyId;
	}

	public OaldeadHead getOaldeadHead() {
		return oaldeadHead;
	}

	public void setOaldeadHead(OaldeadHead oaldeadHead) {
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
