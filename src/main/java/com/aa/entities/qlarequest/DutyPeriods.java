/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

import java.util.List;

public class DutyPeriods {
	private List<DutyPeriodItem> items;

	public List<DutyPeriodItem> getItems() {
		return items;
	}

	public void setItems(List<DutyPeriodItem> items) {
		this.items = items;
	}

}
