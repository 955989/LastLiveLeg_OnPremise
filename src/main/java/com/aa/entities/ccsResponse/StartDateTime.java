/**
 * @author rswami
 * POJO to get sequence pay credit details from CCS service
 */

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
    "formattedLocalTime",
    "gmt",
    "formattedGmt",
    "baseTime",
    "formattedBaseTime"
})
public class StartDateTime {

    @JsonProperty("localTime")
    private String localTime;

    @JsonProperty("formattedLocalTime")
    private String formattedLocalTime;

    @JsonProperty("gmt")
    private String gmt;

    @JsonProperty("formattedGmt")
    private String formattedGmt;

    @JsonProperty("baseTime")
    private String baseTime;

    @JsonProperty("formattedBaseTime")
    private String formattedBaseTime;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("localTime")
    public String getLocalTime() {
        return localTime;
    }

    @JsonProperty("localTime")
    public void setLocalTime(final String localTime) {
        this.localTime = localTime;
    }

    @JsonProperty("gmt")
    public String getGmt() {
        return gmt;
    }

    @JsonProperty("gmt")
    public void setGmt(final String gmt) {
        this.gmt = gmt;
    }

    @JsonProperty("baseTime")
    public String getBaseTime() {
        return baseTime;
    }

    @JsonProperty("baseTime")
    public void setBaseTime(final String baseTime) {
        this.baseTime = baseTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(final String name, final Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("formattedLocalTime")
    public String getFormattedLocalTime() {
        return formattedLocalTime;
    }

    @JsonProperty("formattedLocalTime")
    public void setFormattedLocalTime(final String formattedLocalTime) {
        this.formattedLocalTime = SequenceDateUtil.parseSequenceDateString(formattedLocalTime);
    }

    @JsonProperty("formattedGmt")
    public String getFormattedGmt() {
        return formattedGmt;
    }

    @JsonProperty("formattedGmt")
    public void setFormattedGmt(final String formattedGmt) {
        this.formattedGmt = SequenceDateUtil.parseSequenceDateString(formattedGmt);
    }

    @JsonProperty("formattedBaseTime")
    public String getFormattedBaseTime() {
        return formattedBaseTime;
    }

    @JsonProperty("formattedBaseTime")
    public void setFormattedBaseTime(final String formattedBaseTime) {
        this.formattedBaseTime = SequenceDateUtil.parseSequenceDateString(formattedBaseTime);
    }

    @Override
    public String toString() {
        return "StartDateTime [localTime=" + localTime + ", formattedLocalTime=" + formattedLocalTime + ", gmt=" + gmt
                + ", formattedGmt=" + formattedGmt + ", baseTime=" + baseTime + ", formattedBaseTime="
                + formattedBaseTime + ", additionalProperties=" + additionalProperties + "]";
    }

}
