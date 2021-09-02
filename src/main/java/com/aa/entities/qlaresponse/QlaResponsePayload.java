/**
 *@author ugoudar
 *POJO to get QLA details from QLA Service
 */

package com.aa.entities.qlaresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class QlaResponsePayload {
	private boolean optimizeRules;
	private boolean includeBuffers;
	private boolean skipSequenceValidation;

	@JsonIgnore
	public boolean dailyDisruption;

	public List<EmployeeRespons> employeeResponses;
	public List<String> errorMessages;

	public boolean isDailyDisruption() {
		return dailyDisruption;
	}

	public void setDailyDisruption(boolean dailyDisruption) {
		this.dailyDisruption = dailyDisruption;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public QlaResponsePayload() {

	}

	public boolean isOptimizeRules() {
		return optimizeRules;
	}

	public void setOptimizeRules(boolean optimizeRules) {
		this.optimizeRules = optimizeRules;
	}

	public boolean isIncludeBuffers() {
		return includeBuffers;
	}

	public void setIncludeBuffers(boolean includeBuffers) {
		this.includeBuffers = includeBuffers;
	}

	public boolean isSkipSequenceValidation() {
		return skipSequenceValidation;
	}

	public void setSkipSequenceValidation(boolean skipSequenceValidation) {
		this.skipSequenceValidation = skipSequenceValidation;
	}

	public List<EmployeeRespons> getEmployeeResponses() {
		return employeeResponses;
	}

	public void setEmployeeResponses(List<EmployeeRespons> employeeResponses) {
		this.employeeResponses = employeeResponses;
	}

}
