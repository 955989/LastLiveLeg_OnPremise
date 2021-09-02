/**
 *@author ugoudar
 *POJO to get QLA details from QLA Service
 */

package com.aa.entities.qlaresponse;

import java.util.List;

public class EmployeeRespons {
	private int employeeID;
	private String airlineCode;
	private List<QlaRespons> qlaResponses;
	private List<String> errors;

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public List<QlaRespons> getQlaResponses() {
		return qlaResponses;
	}

	public void setQlaResponses(List<QlaRespons> qlaResponses) {
		this.qlaResponses = qlaResponses;
	}

}
