/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubDelRequest;

import java.util.List;

public class Request_del {
	private String sequenceNumber;
	private String seqOrgDate;
	private List<String> position;
	private boolean commit;
	private boolean transaction;

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

	public void setPosition(List<String> position2) {
		this.position = position2;
	}

	public boolean isCommit() {
		return commit;
	}

	public void setCommit(boolean commit) {
		this.commit = commit;
	}

	public boolean isTransaction() {
		return transaction;
	}

	public void setTransaction(boolean transaction) {
		this.transaction = transaction;
	}

}
