/**
 * @author rswami
 * POJO to get rescheduled details from CCS service
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
    "arrivalAirport",
    "arrivalDateTime",
    "departureAirport",
    "departureDateTime"
})
public class ReScheduled {

    @JsonProperty("arrivalAirport")
    private String arrivalAirport;

    @JsonProperty("arrivalDateTime")
    private ArrivalDateTime arrivalDateTime;

    @JsonProperty("departureAirport")
    private String departureAirport;

    @Override
    public String toString() {
        return "ReScheduled [arrivalAirport=" + arrivalAirport + ", arrivalDateTime=" + arrivalDateTime
                + ", departureAirport=" + departureAirport + ", departureDateTime=" + departureDateTime
                + ", additionalProperties=" + additionalProperties + "]";
    }

    @JsonProperty("departureDateTime")
    private DepartureDateTime departureDateTime;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("arrivalAirport")
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @JsonProperty("arrivalAirport")
    public void setArrivalAirport(final String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @JsonProperty("arrivalDateTime")
    public ArrivalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    @JsonProperty("arrivalDateTime")
    public void setArrivalDateTime(final ArrivalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    @JsonProperty("departureAirport")
    public String getDepartureAirport() {
        return departureAirport;
    }

    @JsonProperty("departureAirport")
    public void setDepartureAirport(final String departureAirport) {
        this.departureAirport = departureAirport;
    }

    @JsonProperty("departureDateTime")
    public DepartureDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    @JsonProperty("departureDateTime")
    public void setDepartureDateTime(final DepartureDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
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
