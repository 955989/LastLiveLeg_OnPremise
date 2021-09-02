/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

import java.util.List;

public class Replies {

	private Open open;
	private List<Add> add;
	private List<Delete> delete;
	private Close close;
	private EndTransaction endTransaction;
	private Object exception;

	public Open getOpen() {
		return open;
	}

	public void setOpen(Open open) {
		this.open = open;
	}

	public List<Add> getAdd() {
		return add;
	}

	public void setAdd(List<Add> add) {
		this.add = add;
	}

	public List<Delete> getDelete() {
		return delete;
	}

	public void setDelete(List<Delete> delete) {
		this.delete = delete;
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
		return "Replies [open=" + open + ", add=" + add + ", delete=" + delete + ", close=" + close
				+ ", endTransaction=" + endTransaction + ", exception=" + exception + "]";
	}

}
