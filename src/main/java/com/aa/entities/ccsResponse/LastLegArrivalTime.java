/**
 * @author rswami
 * POJO to get last leg arrival time from CCS service
 **/

package com.aa.entities.ccsResponse;

public class LastLegArrivalTime {
    private String localTime;

    private String gmt;

    private String baseTime;

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(final String localTime) {
        this.localTime = localTime;
    }

    public String getGmt() {
        return gmt;
    }

    public void setGmt(final String gmt) {
        this.gmt = gmt;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(final String baseTime) {
        this.baseTime = baseTime;
    }

    @Override
    public String toString() {
        return "LastLegArrivalTime [localTime=" + localTime + ", gmt=" + gmt + ", baseTime=" + baseTime + "]";
    }
}
