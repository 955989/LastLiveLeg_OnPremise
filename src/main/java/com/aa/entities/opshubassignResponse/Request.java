/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubassignResponse;

public class Request {
	private Assign assign;
	private Object remove;
	private Object actionCode;
	private Object employeeNumber;
	private Object seat;
	private Object sequenceNumber;
	private Object sequenceOriginationDate;
	private Object reasonCode;
	private Object swapSeat;
	private boolean transaction;
	private boolean commit;

	public Assign getAssign() {
		return assign;
	}

	public void setAssign(Assign assign) {
		this.assign = assign;
	}

	public Object getRemove() {
		return remove;
	}

	public void setRemove(Object remove) {
		this.remove = remove;
	}

	public Object getActionCode() {
		return actionCode;
	}

	public void setActionCode(Object actionCode) {
		this.actionCode = actionCode;
	}

	public Object getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Object employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Object getSeat() {
		return seat;
	}

	public void setSeat(Object seat) {
		this.seat = seat;
	}

	public Object getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Object sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public Object getSequenceOriginationDate() {
		return sequenceOriginationDate;
	}

	public void setSequenceOriginationDate(Object sequenceOriginationDate) {
		this.sequenceOriginationDate = sequenceOriginationDate;
	}

	public Object getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(Object reasonCode) {
		this.reasonCode = reasonCode;
	}

	public Object getSwapSeat() {
		return swapSeat;
	}

	public void setSwapSeat(Object swapSeat) {
		this.swapSeat = swapSeat;
	}

	public boolean isTransaction() {
		return transaction;
	}

	public void setTransaction(boolean transaction) {
		this.transaction = transaction;
	}

	public boolean isCommit() {
		return commit;
	}

	public void setCommit(boolean commit) {
		this.commit = commit;
	}

	@Override
	public String toString() {
		return "Request [assign=" + assign + ", remove=" + remove + ", actionCode=" + actionCode + ", employeeNumber="
				+ employeeNumber + ", seat=" + seat + ", sequenceNumber=" + sequenceNumber
				+ ", sequenceOriginationDate=" + sequenceOriginationDate + ", reasonCode=" + reasonCode + ", swapSeat="
				+ swapSeat + ", transaction=" + transaction + ", commit=" + commit + "]";
	}

}