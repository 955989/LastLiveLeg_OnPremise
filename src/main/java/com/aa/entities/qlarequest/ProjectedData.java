/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

import java.util.List;

public class ProjectedData {
	private List<SequenceDetail> sequenceDetails;

	public List<SequenceDetail> getSequenceDetails() {
		return sequenceDetails;
	}

	public void setSequenceDetails(List<SequenceDetail> sequenceDetails) {
		this.sequenceDetails = sequenceDetails;
	}

	@Override
	public String toString() {
		return "ProjectedData [sequenceDetails=" + sequenceDetails + "]";
	}

}
