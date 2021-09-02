/**
 * Pojo to store details of HSS first line
 */

package com.aa.entities.ccsentities;

public class FirstLineOfHSS_Entity {
    private String base;

    private String flightType; // DOM ot INT

    private String equipmentGroup;

    public FirstLineOfHSS_Entity() {
        super();
    }

    @Override
    public String toString() {
        return "FirstLineOfHSS_Details [base=" + base + ", flightType=" + flightType + ", equipmentGroup=" + equipmentGroup
                + "]";
    }

    public String getBase() {
        return base;
    }

    public void setBase(final String base) {
        this.base = base;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(final String flightType) {
        this.flightType = flightType;
    }

    public String getEquipmentGroup() {
        return equipmentGroup;
    }

    public void setEquipmentGroup(final String equipmentGroup) {
        this.equipmentGroup = equipmentGroup;
    }
}
