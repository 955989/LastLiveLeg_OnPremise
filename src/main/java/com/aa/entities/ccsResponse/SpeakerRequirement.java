/**
 * @author rswami
 * POJO to get speaker requirment details from CCS service
 */

package com.aa.entities.ccsResponse;

public class SpeakerRequirement {
    private boolean posSpeakerRestricted;

    private int totalRequiredForSeq;

    private int totalMissingForSeq;

    private int totalRequiredForCabin;

    private int totalMissingForCabin;

    private boolean nonCabinSpecific;

    public boolean isPosSpeakerRestricted() {
        return posSpeakerRestricted;
    }

    public void setPosSpeakerRestricted(final boolean posSpeakerRestricted) {
        this.posSpeakerRestricted = posSpeakerRestricted;
    }

    @Override
    public String toString() {
        return "SpeakerRequirement [posSpeakerRestricted=" + posSpeakerRestricted + ", totalRequiredForSeq="
                + totalRequiredForSeq + ", totalMissingForSeq=" + totalMissingForSeq + ", totalRequiredForCabin="
                + totalRequiredForCabin + ", totalMissingForCabin=" + totalMissingForCabin + ", nonCabinSpecific="
                + nonCabinSpecific + "]";
    }

    public int getTotalRequiredForSeq() {
        return totalRequiredForSeq;
    }

    public void setTotalRequiredForSeq(final int totalRequiredForSeq) {
        this.totalRequiredForSeq = totalRequiredForSeq;
    }

    public int getTotalMissingForSeq() {
        return totalMissingForSeq;
    }

    public void setTotalMissingForSeq(final int totalMissingForSeq) {
        this.totalMissingForSeq = totalMissingForSeq;
    }

    public int getTotalRequiredForCabin() {
        return totalRequiredForCabin;
    }

    public void setTotalRequiredForCabin(final int totalRequiredForCabin) {
        this.totalRequiredForCabin = totalRequiredForCabin;
    }

    public int getTotalMissingForCabin() {
        return totalMissingForCabin;
    }

    public void setTotalMissingForCabin(final int totalMissingForCabin) {
        this.totalMissingForCabin = totalMissingForCabin;
    }

    public boolean isNonCabinSpecific() {
        return nonCabinSpecific;
    }

    public void setNonCabinSpecific(final boolean nonCabinSpecific) {
        this.nonCabinSpecific = nonCabinSpecific;
    }
}
