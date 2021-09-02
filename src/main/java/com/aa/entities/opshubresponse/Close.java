/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

public class Close {
	private CloseMode closeMode;
	private Object crewPositionsAfterClose;
	private Object replyId;
	private String value;
	private String status;

	public CloseMode getCloseMode() {
		return closeMode;
	}

	public void setCloseMode(CloseMode closeMode) {
		this.closeMode = closeMode;
	}

	public Object getCrewPositionsAfterClose() {
		return crewPositionsAfterClose;
	}

	public void setCrewPositionsAfterClose(Object crewPositionsAfterClose) {
		this.crewPositionsAfterClose = crewPositionsAfterClose;
	}

	public Object getReplyId() {
		return replyId;
	}

	public void setReplyId(Object replyId) {
		this.replyId = replyId;
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
		return "Close [closeMode=" + closeMode + ", crewPositionsAfterClose=" + crewPositionsAfterClose + ", replyId="
				+ replyId + ", value=" + value + ", status=" + status + "]";
	}

}
