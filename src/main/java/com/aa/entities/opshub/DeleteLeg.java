/**
 *@author sivan
 *POJO to store delete leg details from OpsHub Service
 */

package com.aa.entities.opshub;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteLeg {

    private NormalFlightLeg normalFlightLeg;

    @JsonProperty("oaldeadHeadFltLeg")
    private OaldeadHeaddel oaldeadHeaddel;

    public NormalFlightLeg getNormalFlightLeg() {

        return normalFlightLeg;
    }

    public void setNormalFlightLeg(final NormalFlightLeg normalFlightLeg) {
        this.normalFlightLeg = normalFlightLeg;
    }

    public OaldeadHeaddel getOaldeadHeaddel() {
        return oaldeadHeaddel;
    }

    public void setOaldeadHeaddel(final OaldeadHeaddel oaldeadHeaddel) {
        this.oaldeadHeaddel = oaldeadHeaddel;
    }

    @Override
    public String toString() {
        return "DeleteLeg [normalFlightLeg=" + normalFlightLeg + ", oaldeadHeaddel=" + oaldeadHeaddel + "]";
    }

    /*
     * public List<NormalFlightLeg> getNormalFlightLeg() { return normalFlightLeg; }
     *
     * public void setNormalFlightLeg(List<NormalFlightLeg> normalFlightLeg) { this.normalFlightLeg
     * = normalFlightLeg; }
     */

}
