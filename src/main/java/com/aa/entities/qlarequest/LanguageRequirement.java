/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class LanguageRequirement {
	private String langCode;
	private int langCount;

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public int getLangCount() {
		return langCount;
	}

	public void setLangCount(int langCount) {
		this.langCount = langCount;
	}

	@Override
	public String toString() {
		return "LanguageRequirement [langCode=" + langCode + ", langCount=" + langCount + "]";
	}

}
