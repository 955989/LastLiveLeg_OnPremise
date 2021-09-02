/**
 *@author sivan
 *POJO to store opshub assignment details to OpsHub Service
 */

package com.aa.entities.opshubassignRequest;


public class OpshubRequest {
	private OpshubAssign AssignObject;
	private boolean commit;
	private boolean transaction;

	// Getter Methods

	public OpshubAssign getAssign() {
		return AssignObject;
	}

	public boolean getCommit() {
		return commit;
	}

	public boolean getTransaction() {
		return transaction;
	}

	// Setter Methods

	public void setAssign(OpshubAssign assignObject) {
		this.AssignObject = assignObject;
	}

	public void setCommit(boolean commit) {
		this.commit = commit;
	}

	public void setTransaction(boolean transaction) {
		this.transaction = transaction;
	}
}
