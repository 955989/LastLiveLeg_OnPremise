/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubassignResponse;

public class Reply {
	private String status;
	private String data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Reply [status=" + status + ", data=" + data + "]";
	}

}