/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

public class CreateSequence {
	private CreateDomesticSequence createDomesticSequence;
	private Object createInternationalSequence;
	private String value;
	private Object replyId;
	private String status;

	public CreateDomesticSequence getCreateDomesticSequence() {
		return createDomesticSequence;
	}

	public void setCreateDomesticSequence(CreateDomesticSequence createDomesticSequence) {
		this.createDomesticSequence = createDomesticSequence;
	}

	public Object getCreateInternationalSequence() {
		return createInternationalSequence;
	}

	public void setCreateInternationalSequence(Object createInternationalSequence) {
		this.createInternationalSequence = createInternationalSequence;
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
		return "CreateSequence [createDomesticSequence=" + createDomesticSequence + ", createInternationalSequence="
				+ createInternationalSequence + ", value=" + value + ", replyId=" + replyId + ", status=" + status
				+ "]";
	}

}