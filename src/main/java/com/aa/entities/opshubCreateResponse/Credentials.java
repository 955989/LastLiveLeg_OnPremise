/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

public class Credentials {
	private String alias;
	private Object user;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Credentials [alias=" + alias + ", user=" + user + "]";
	}

}
