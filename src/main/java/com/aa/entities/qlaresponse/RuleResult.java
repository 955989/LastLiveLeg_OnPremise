/**
 *@author ugoudar
 *POJO to get QLA details from QLA Service
 */

package com.aa.entities.qlaresponse;

import java.util.List;

public class RuleResult {
	private String rule;
	private String result;
	private List<String> messages;

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
