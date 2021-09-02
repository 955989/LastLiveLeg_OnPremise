/**
 *@author sivan
 *POJO to store common partition details from OpsHub Service
 */

package com.aa.entities.opshub;

public class CommonPartition {

    private String partitionCode;

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(final String partitionCode) {
        this.partitionCode = partitionCode;
    }

    @Override
    public String toString() {
        return "CommonPartition [partitionCode=" + partitionCode + "]";
    }

}
