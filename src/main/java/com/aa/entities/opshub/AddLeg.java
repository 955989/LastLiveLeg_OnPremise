/**
 *@author sivan
 *POJO to store oal deadhead details from OpsHub Service
 */

package com.aa.entities.opshub;

public class AddLeg {

    private OaldeadHead oaldeadHead;

    private NormalFlightLeg normalFlightLeg;

    public OaldeadHead getOaldeadHead() {
        return oaldeadHead;
    }

    public NormalFlightLeg getNormalFlightLeg() {
        return normalFlightLeg;
    }

    public void setNormalFlightLeg(final NormalFlightLeg normalFlightLeg) {
        this.normalFlightLeg = normalFlightLeg;
    }

    public void setOaldeadHead(final OaldeadHead oaldeadHead) {
        this.oaldeadHead = oaldeadHead;
    }

    @Override
    public String toString() {
        return "AddLeg [oaldeadHead=" + oaldeadHead + ", normalFlightLeg=" + normalFlightLeg + "]";
    }

}
