/**
 *@author sivan
 *POJO to get opshub details to OpsHub Service
 */

package com.aa.entities.opshubCreateRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Add {

	private NormalFlightLeg normalFlightLeg;
	private ReportLeg reportLeg;
	@JsonProperty("oaldeadHead")
	private OaldeadHead1 oaldeadHead1;

	public NormalFlightLeg getNormalFlightLeg() {
		return normalFlightLeg;
	}

	public void setNormalFlightLeg(NormalFlightLeg normalFlightLeg) {
		this.normalFlightLeg = normalFlightLeg;
	}

	public ReportLeg getReportLeg() {
		return reportLeg;
	}

	public void setReportLeg(ReportLeg reportLeg) {
		this.reportLeg = reportLeg;
	}

	public OaldeadHead1 getOaldeadHead1() {
		return oaldeadHead1;
	}

	public void setOaldeadHead1(OaldeadHead1 oaldeadHead1) {
		this.oaldeadHead1 = oaldeadHead1;
	}

	@Override
	public String toString() {
		return "Add [normalFlightLeg=" + normalFlightLeg + ", reportLeg=" + reportLeg + ", oaldeadHead1=" + oaldeadHead1
				+ "]";
	}

}
