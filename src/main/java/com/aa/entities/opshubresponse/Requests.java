/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

import java.util.List;

public class Requests {

	private Common common;
	private Open open;
	private List<Delete> delete;
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

	public Open getOpen() {
		return open;
	}

	public void setOpen(Open open) {
		this.open = open;
	}

	public List<Delete> getDelete() {
		return delete;
	}

	public void setDelete(List<Delete> delete) {
		this.delete = delete;
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
		return "Requests [common=" + common + ", open=" + open + ", delete=" + delete + ", add=" + add + ", close="
				+ close + ", endTransaction=" + endTransaction + ", ignoreTransaction=" + ignoreTransaction + "]";
	}

}
