/**
 *@author sivan
 *POJO to get opshub details to OpsHub Service
 */

package com.aa.entities.opshubCreateRequest;

public class CreateDomesticSequence {

	private String crewBase;
	private String equipmentGroup;
	private String seqOrgDate;

	public String getCrewBase() {
		return crewBase;
	}

	public String setCrewBase(String crewBase) {
		this.crewBase = crewBase;
		return crewBase;
	}

	public String getEquipmentGroup() {
		return equipmentGroup;
	}

	public void setEquipmentGroup(String equipmentGroup) {
		this.equipmentGroup = equipmentGroup;
	}

	public String getSeqOrgDate() {
		return seqOrgDate;
	}

	public void setSeqOrgDate(String seqOrgDate) {
		this.seqOrgDate = seqOrgDate;
	}

}
