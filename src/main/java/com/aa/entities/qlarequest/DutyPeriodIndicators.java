/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

public class DutyPeriodIndicators {
	private boolean pilotAugmentationFour;
	private boolean pilotAugmentationThree;
	private int restFacilityClass;

	public boolean isPilotAugmentationFour() {
		return pilotAugmentationFour;
	}

	public void setPilotAugmentationFour(boolean pilotAugmentationFour) {
		this.pilotAugmentationFour = pilotAugmentationFour;
	}

	public boolean isPilotAugmentationThree() {
		return pilotAugmentationThree;
	}

	public void setPilotAugmentationThree(boolean pilotAugmentationThree) {
		this.pilotAugmentationThree = pilotAugmentationThree;
	}

	public int getRestFacilityClass() {
		return restFacilityClass;
	}

	public void setRestFacilityClass(int restFacilityClass) {
		this.restFacilityClass = restFacilityClass;
	}

}
