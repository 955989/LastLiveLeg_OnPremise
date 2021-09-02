/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

import java.util.List;

public class Replies {
	private CreateSequence createSequence;
	private List<Add> add;
	private Close close;
	private EndTransaction endTransaction;
	private Object exception;

	public CreateSequence getCreateSequence() {
		return createSequence;
	}

	public void setCreateSequence(CreateSequence createSequence) {
		this.createSequence = createSequence;
	}

	public List<Add> getAdd() {
		return add;
	}

	public void setAdd(List<Add> add) {
		this.add = add;
	}

	public Close getClose() {
		return close;
	}

	public void setClose(Close close) {
		this.close = close;
	}

	public EndTransaction getEndTransaction() {
		return endTransaction;
	}

	public void setEndTransaction(EndTransaction endTransaction) {
		this.endTransaction = endTransaction;
	}

	public Object getException() {
		return exception;
	}

	public void setException(Object exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "Replies [createSequence=" + createSequence + ", add=" + add + ", close=" + close + ", endTransaction="
				+ endTransaction + ", exception=" + exception + "]";
	}

}