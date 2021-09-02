/**
 *@author sivan
 *POJO to store opshub details from OpsHub Service
 */

package com.aa.entities.opshubCreateResponse;

public class CreateDomesticSequence {
	private String crewBase;
	private String equipmentGroup;
	private Object assignedSequence;
	private String seqOrgDate;
	private Object seqEndDate;
	private Object frequency;
	private Object classNumber;

	public String getCrewBase() {
		return crewBase;
	}

	public void setCrewBase(String crewBase) {
		this.crewBase = crewBase;
	}

	public String getEquipmentGroup() {
		return equipmentGroup;
	}

	public void setEquipmentGroup(String equipmentGroup) {
		this.equipmentGroup = equipmentGroup;
	}

	public Object getAssignedSequence() {
		return assignedSequence;
	}

	public void setAssignedSequence(Object assignedSequence) {
		this.assignedSequence = assignedSequence;
	}

	public String getSeqOrgDate() {
		return seqOrgDate;
	}

	public void setSeqOrgDate(String seqOrgDate) {
		this.seqOrgDate = seqOrgDate;
	}

	public Object getSeqEndDate() {
		return seqEndDate;
	}

	public void setSeqEndDate(Object seqEndDate) {
		this.seqEndDate = seqEndDate;
	}

	public Object getFrequency() {
		return frequency;
	}

	public void setFrequency(Object frequency) {
		this.frequency = frequency;
	}

	public Object getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Object classNumber) {
		this.classNumber = classNumber;
	}

	@Override
	public String toString() {
		return "CreateDomesticSequence [crewBase=" + crewBase + ", equipmentGroup=" + equipmentGroup
				+ ", assignedSequence=" + assignedSequence + ", seqOrgDate=" + seqOrgDate + ", seqEndDate=" + seqEndDate
				+ ", frequency=" + frequency + ", classNumber=" + classNumber + "]";
	}

}
