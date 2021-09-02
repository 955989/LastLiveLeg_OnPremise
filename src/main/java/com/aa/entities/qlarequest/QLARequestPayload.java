/**
 *@author ugoudar
 *POJO to store QLA details to send QLA Service
 */

package com.aa.entities.qlarequest;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@ToString
public class QLARequestPayload {
	private List<Employee> employees;
	private String optimizeRules;
	private ProjectedData projectedData;

//    public QLARequestPayload() {
//    	
//    }

	public QLARequestPayload() {
		// TODO Auto-generated constructor stub
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getOptimizeRules() {
		return optimizeRules;
	}

	public void setOptimizeRules(String optimizeRules) {
		this.optimizeRules = optimizeRules;
	}

	public ProjectedData getProjectedData() {
		return projectedData;
	}

	public void setProjectedData(ProjectedData projectedData) {
		this.projectedData = projectedData;
	}

	@Override
	public String toString() {
		return "QLARequest [employees=" + employees + ", optimizeRules=" + optimizeRules + ", projectedData="
				+ projectedData + "]";
	}

}
