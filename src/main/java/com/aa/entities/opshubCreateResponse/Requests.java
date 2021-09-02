/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

import java.util.List;

public class Requests {
	private Common common;
	private CreateSequence createSequence;
	private List<Add> add;
	private Close close;
	private String endTransaction;
	private Object ignoreTransaction;

	public Common getCommon() {
		return common;
	}

	public void setCommon(Common common) {
		this.common = common;
	}

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

	public String getEndTransaction() {
		return endTransaction;
	}

	public void setEndTransaction(String endTransaction) {
		this.endTransaction = endTransaction;
	}

	public Object getIgnoreTransaction() {
		return ignoreTransaction;
	}

	public void setIgnoreTransaction(Object ignoreTransaction) {
		this.ignoreTransaction = ignoreTransaction;
	}

	@Override
	public String toString() {
		return "Requests [common=" + common + ", createSequence=" + createSequence + ", add=" + add + ", close=" + close
				+ ", endTransaction=" + endTransaction + ", ignoreTransaction=" + ignoreTransaction + "]";
	}

}