/**
 * @author rswami
 * POJO to get sequence pay credit details from CCS service
 */

package com.aa.entities.ccsResponse;

public class SequencePayCredit {
    private int greaterTime;

    private int scheduledBlockTime;

    private int actualBlockTime;

    private int scheduledTotalCredit;

    private int actualTotalCredit;

    private int deadheadCredit;

    private int scheduledRig;

    private int actualRig;

    private int payProtectedValue;

    private int totalSequenceCredit;

    public int getGreaterTime() {
        return greaterTime;
    }

    public void setGreaterTime(final int greaterTime) {
        this.greaterTime = greaterTime;
    }

    public int getScheduledBlockTime() {
        return scheduledBlockTime;
    }

    public void setScheduledBlockTime(final int scheduledBlockTime) {
        this.scheduledBlockTime = scheduledBlockTime;
    }

    public int getActualBlockTime() {
        return actualBlockTime;
    }

    public void setActualBlockTime(final int actualBlockTime) {
        this.actualBlockTime = actualBlockTime;
    }

    public int getScheduledTotalCredit() {
        return scheduledTotalCredit;
    }

    public void setScheduledTotalCredit(final int scheduledTotalCredit) {
        this.scheduledTotalCredit = scheduledTotalCredit;
    }

    public int getActualTotalCredit() {
        return actualTotalCredit;
    }

    public void setActualTotalCredit(final int actualTotalCredit) {
        this.actualTotalCredit = actualTotalCredit;
    }

    public int getDeadheadCredit() {
        return deadheadCredit;
    }

    public void setDeadheadCredit(final int deadheadCredit) {
        this.deadheadCredit = deadheadCredit;
    }

    public int getScheduledRig() {
        return scheduledRig;
    }

    public void setScheduledRig(final int scheduledRig) {
        this.scheduledRig = scheduledRig;
    }

    public int getActualRig() {
        return actualRig;
    }

    public void setActualRig(final int actualRig) {
        this.actualRig = actualRig;
    }

    public int getPayProtectedValue() {
        return payProtectedValue;
    }

    public void setPayProtectedValue(final int payProtectedValue) {
        this.payProtectedValue = payProtectedValue;
    }

    public int getTotalSequenceCredit() {
        return totalSequenceCredit;
    }

    @Override
    public String toString() {
        return "SequencePayCredit [greaterTime=" + greaterTime + ", scheduledBlockTime=" + scheduledBlockTime
                + ", actualBlockTime=" + actualBlockTime + ", scheduledTotalCredit=" + scheduledTotalCredit
                + ", actualTotalCredit=" + actualTotalCredit + ", deadheadCredit=" + deadheadCredit + ", scheduledRig="
                + scheduledRig + ", actualRig=" + actualRig + ", payProtectedValue=" + payProtectedValue
                + ", totalSequenceCredit=" + totalSequenceCredit + "]";
    }

    public void setTotalSequenceCredit(final int totalSequenceCredit) {
        this.totalSequenceCredit = totalSequenceCredit;
    }
}
