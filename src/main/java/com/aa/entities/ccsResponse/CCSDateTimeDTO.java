/**
 * @author rswami
 * POJO to get Sequence details from CCS service
 **/

package com.aa.entities.ccsResponse;

import java.io.Serializable;

public class CCSDateTimeDTO implements Serializable {

    private static final long serialVersionUID = 2136373614429948220L;

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
        return "CCSDateTimeDTO [localTime=" + localTime + ", gmt=" + gmt + ", baseTime=" + baseTime + "]";
    }

    // @Override
    // public String toString() {
    // return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    // }
}
