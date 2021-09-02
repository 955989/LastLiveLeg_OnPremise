/**
 * @author rswami
 * POJO to get Equipment qualifications from CCS service
 **/

package com.aa.entities.ccsResponse;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "equipmentGroup",
    "equipmentNumber",
    "equipmentType"
})
public class EquipmentQuals {

    @Override
    public String toString() {
        return "EquipmentQuals [equipmentGroup=" + equipmentGroup + ", equipmentNumber=" + equipmentNumber
                + ", equipmentType=" + equipmentType + ", additionalProperties=" + additionalProperties + "]";
    }

    private String equipmentGroup;

    private String equipmentNumber;

    private String equipmentType;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getEquipmentGroup() {
        return equipmentGroup;
    }

    public void setEquipmentGroup(final String equipmentGroup) {
        this.equipmentGroup = equipmentGroup;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(final String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(final String equipmentType) {
        this.equipmentType = equipmentType;
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
