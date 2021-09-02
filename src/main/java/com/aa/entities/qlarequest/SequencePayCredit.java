/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;


public class SequencePayCredit {
	private int actualBlockTime;
	private int actualDpCredit;

	private int actualRig;

	private int actualSeqCredit;

	private int actualTotalCredit;
	private int deadheadCredit;
	private int greaterTime;
	private int scheduledBlockTime;
	private int scheduledDpCredit;
	private int scheduledRig;
	private int scheduledTotalCredit;
	private int scheduledSeqCredit;

	public int getActualBlockTime() {
		return actualBlockTime;
	}

	public void setActualBlockTime(int actualBlockTime) {
		this.actualBlockTime = actualBlockTime;
	}

	public int getActualDpCredit() {
		return actualDpCredit;
	}

	public void setActualDpCredit(int actualDpCredit) {
		this.actualDpCredit = actualDpCredit;
	}

	public int getActualRig() {
		return actualRig;
	}

	public void setActualRig(int actualRig) {
		this.actualRig = actualRig;
	}

	public int getActualTotalCredit() {
		return actualTotalCredit;
	}

	public void setActualTotalCredit(int actualTotalCredit) {
		this.actualTotalCredit = actualTotalCredit;
	}

	public int getDeadheadCredit() {
		return deadheadCredit;
	}

	public void setDeadheadCredit(int deadheadCredit) {
		this.deadheadCredit = deadheadCredit;
	}

	public int getGreaterTime() {
		return greaterTime;
	}

	public void setGreaterTime(int greaterTime) {
		this.greaterTime = greaterTime;
	}

	public int getScheduledBlockTime() {
		return scheduledBlockTime;
	}

	public void setScheduledBlockTime(int scheduledBlockTime) {
		this.scheduledBlockTime = scheduledBlockTime;
	}

	public int getScheduledDpCredit() {
		return scheduledDpCredit;
	}

	public void setScheduledDpCredit(int scheduledDpCredit) {
		this.scheduledDpCredit = scheduledDpCredit;
	}

	public int getScheduledRig() {
		return scheduledRig;
	}

	public void setScheduledRig(int scheduledRig) {
		this.scheduledRig = scheduledRig;
	}

	public int getScheduledTotalCredit() {
		return scheduledTotalCredit;
	}

	public void setScheduledTotalCredit(int scheduledTotalCredit) {
		this.scheduledTotalCredit = scheduledTotalCredit;
	}

	@Override
	public String toString() {
		return "SequencePayCredit [actualBlockTime=" + actualBlockTime + ", actualDpCredit=" + actualDpCredit
				+ ", actualRig=" + actualRig + ", actualSeqCredit=" + actualSeqCredit + ", actualTotalCredit="
				+ actualTotalCredit + ", deadheadCredit=" + deadheadCredit + ", greaterTime=" + greaterTime
				+ ", scheduledBlockTime=" + scheduledBlockTime + ", scheduledDpCredit=" + scheduledDpCredit
				+ ", scheduledRig=" + scheduledRig + ", scheduledTotalCredit=" + scheduledTotalCredit
				+ ", scheduledSeqCredit=" + scheduledSeqCredit + "]";
	}

	public int getActualSeqCredit() {
		return actualSeqCredit;
	}

	public void setActualSeqCredit(int actualSeqCredit) {
		this.actualSeqCredit = actualSeqCredit;
	}

	public int getScheduledSeqCredit() {
		return scheduledSeqCredit;
	}

	public void setScheduledSeqCredit(int scheduledSeqCredit) {
		this.scheduledSeqCredit = scheduledSeqCredit;
	}

}
