
/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubDelResponse;

public class Credentials_del {

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
		return "Credentials_del [alias=" + alias + ", user=" + user + "]";
	}

}
