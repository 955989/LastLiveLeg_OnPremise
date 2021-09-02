/**
 * @author rswami
 * POJO to store arrival date and time of flight
 **/

package com.aa.entities.ccsResponse;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "localTime",
    "gmt",
    "baseTime"

})
public class ArrivalDateTime {

    @Override
    public String toString() {
        return "ArrivalDateTime [baseTime=" + baseTime + ", gmt=" + gmt + ", localTime=" + localTime
                + ", additionalProperties=" + additionalProperties + "]";
    }

    @JsonProperty("baseTime")
    private String baseTime;

    @JsonProperty("gmt")
    private String gmt;

    @JsonProperty("localTime")
    private String localTime;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("baseTime")
    public String getBaseTime() {
        return baseTime;
    }

    @JsonProperty("baseTime")
    public void setBaseTime(final String baseTime) {
        this.baseTime = baseTime;
    }

    @JsonProperty("gmt")
    public String getGmt() {
        return gmt;
    }

    @JsonProperty("gmt")
    public void setGmt(final String gmt) {
        this.gmt = gmt;
    }

    @JsonProperty("localTime")
    public String getLocalTime() {
        return localTime;
    }

    @JsonProperty("localTime")
    public void setLocalTime(final String localTime) {
        this.localTime = localTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(final String name, final Object value) {
        this.additionalProperties.put(name, value);
    }

}
