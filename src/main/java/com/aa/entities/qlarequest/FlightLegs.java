/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

import java.util.List;

//@Service
public class FlightLegs {
	private List<LegItem> items;

	public List<LegItem> getItems() {
		return items;
	}

	public void setItems(List<LegItem> items) {
		this.items = items;
	}

}
