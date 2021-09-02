/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

import java.util.List;

public class Request {

	private List<PickupDutyList> pickupDutyList;
	private int requestId;

	@Override
	public String toString() {
		return "Request [ pickupDutyList=" + pickupDutyList + ", requestId=" + requestId + "]";
	}

	public List<PickupDutyList> getPickupDutyList() {
		return pickupDutyList;
	}

	public void setPickupDutyList(List<PickupDutyList> pickupDutyList) {
		this.pickupDutyList = pickupDutyList;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

}
