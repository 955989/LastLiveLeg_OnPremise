/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

public class EndTransaction {
	private String value;
	private Object replyId;
	private String status;

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
		return "EndTransaction [value=" + value + ", replyId=" + replyId + ", status=" + status + "]";
	}

}
