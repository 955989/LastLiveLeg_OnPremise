/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightLegStatusProperties {
	@JsonProperty("ACTIVE")
	private boolean aCTIVE;

	public boolean isaCTIVE() {
		return aCTIVE;
	}

	public void setaCTIVE(boolean aCTIVE) {
		this.aCTIVE = aCTIVE;
	}

}
