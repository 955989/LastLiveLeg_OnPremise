
/**
 *@author sivan
 *POJO to get opshub details from OpsHub Service
 */

package com.aa.entities.opshubresponse;

public class Common {

	private String partitionCode;

	public String getPartitionCode() {
		return partitionCode;
	}

	public void setPartitionCode(String partitionCode) {
		this.partitionCode = partitionCode;
	}

	@Override
	public String toString() {
		return "Common [partitionCode=" + partitionCode + "]";
	}

}
