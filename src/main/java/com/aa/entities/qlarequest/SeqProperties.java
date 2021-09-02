/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class SeqProperties {
	private boolean advIndicator;
	private boolean cfdIndicator;

	public boolean isAdvIndicator() {
		return advIndicator;
	}

	public void setAdvIndicator(boolean advIndicator) {
		this.advIndicator = advIndicator;
	}

	public boolean isCfdIndicator() {
		return cfdIndicator;
	}

	public void setCfdIndicator(boolean cfdIndicator) {
		this.cfdIndicator = cfdIndicator;
	}

}
