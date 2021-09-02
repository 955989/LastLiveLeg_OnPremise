/**
 *@author ugoudar
 *POJO to get QLA details from QLA Service
 */

package com.aa.entities.qlaresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QlaRespons {
	private String requestId;
	private boolean valid;
	private boolean legal;
	private boolean contractual;
	private boolean qualified;

	@JsonProperty(defaultValue = "NoRules")
	public List<RuleResult> ruleResults;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isLegal() {
		return legal;
	}

	public void setLegal(boolean legal) {
		this.legal = legal;
	}

	public boolean isContractual() {
		return contractual;
	}

	public void setContractual(boolean contractual) {
		this.contractual = contractual;
	}

	public boolean isQualified() {
		return qualified;
	}

	public void setQualified(boolean qualified) {
		this.qualified = qualified;
	}

	public List<RuleResult> getRuleResults() {
		return ruleResults;
	}

	public void setRuleResults(List<RuleResult> ruleResults) {
		this.ruleResults = ruleResults;
	}

}
