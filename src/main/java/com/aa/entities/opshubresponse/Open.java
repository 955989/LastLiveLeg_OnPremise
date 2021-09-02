/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

public class Open {

	private ModifyNormalSequence modifyNormalSequence;
	private Object modifyTrainingSequence;
	private String value;
	private Object replyId;
	private String status;

	public ModifyNormalSequence getModifyNormalSequence() {
		return modifyNormalSequence;
	}

	public void setModifyNormalSequence(ModifyNormalSequence modifyNormalSequence) {
		this.modifyNormalSequence = modifyNormalSequence;
	}

	public Object getModifyTrainingSequence() {
		return modifyTrainingSequence;
	}

	public void setModifyTrainingSequence(Object modifyTrainingSequence) {
		this.modifyTrainingSequence = modifyTrainingSequence;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Object getReplyId() {
		return replyId;
	}

	public void setReplyId(Object replyId) {
		this.replyId = replyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Open [modifyNormalSequence=" + modifyNormalSequence + ", modifyTrainingSequence="
				+ modifyTrainingSequence + ", value=" + value + ", replyId=" + replyId + ", status=" + status + "]";
	}

}
