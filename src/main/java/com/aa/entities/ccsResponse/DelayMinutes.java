/**
 * @author rswami
 * POJO to get Sequence details from CCS service
 **/

package com.aa.entities.ccsResponse;

public class DelayMinutes {
    private int atcDelays;

    private int deicingDelays;

    private int rampDelays;

    public int getAtcDelays() {
        return atcDelays;
    }

    public void setAtcDelays(final int atcDelays) {
        this.atcDelays = atcDelays;
    }

    @Override
    public String toString() {
        return "DelayMinutes [atcDelays=" + atcDelays + ", deicingDelays=" + deicingDelays + ", rampDelays="
                + rampDelays + "]";
    }

    public int getDeicingDelays() {
        return deicingDelays;
    }

    public void setDeicingDelays(final int deicingDelays) {
        this.deicingDelays = deicingDelays;
    }

    public int getRampDelays() {
        return rampDelays;
    }

    public void setRampDelays(final int rampDelays) {
        this.rampDelays = rampDelays;
    }
}
