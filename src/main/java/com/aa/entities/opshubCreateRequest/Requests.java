/**
 *@author sivan
 *POJO to get opshub details to OpsHub Service
 */

package com.aa.entities.opshubCreateRequest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Requests {
	private CreateSequence createSequence;
	private Common common;
	private List<Add> add;
	private Close close;
	private boolean endTransaction;

	public CreateSequence getCreateSequence() {
		return createSequence;
	}

	public void setCreateSequence(CreateSequence createSequence) {
		this.createSequence = createSequence;
	}

	public Common getCommon() {
		return common;
	}

	public void setCommon(Common common) {
		this.common = common;
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

	public boolean getEndTransaction() {
		return endTransaction;
	}

	public void setEndTransaction(boolean endTransaction) {
		this.endTransaction = endTransaction;
	}

}
