/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubDelResponse;

import java.util.List;

public class Request_del {

	private String sequenceNumber;
	private String seqOrgDate;
	private List<String> position;
	private boolean transaction;
	private boolean commit;

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getSeqOrgDate() {
		return seqOrgDate;
	}

	public void setSeqOrgDate(String seqOrgDate) {
		this.seqOrgDate = seqOrgDate;
	}

	public List<String> getPosition() {
		return position;
	}

	public void setPosition(List<String> position) {
		this.position = position;
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
		return "Request_del [sequenceNumber=" + sequenceNumber + ", seqOrgDate=" + seqOrgDate + ", position=" + position
				+ ", transaction=" + transaction + ", commit=" + commit + "]";
	}

}
