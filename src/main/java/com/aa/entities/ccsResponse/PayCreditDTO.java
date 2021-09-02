/**
 * @author rswami
 * POJO to get pay credit DTO from CCS service
 */

package com.aa.entities.ccsResponse;

public class PayCreditDTO {

    private int greaterTime;

    private int scheduledFlight;

    private int actualFlight;

    private int scheduledCredit;

    private int actualCredit;

    private int deadheadCredit;

    private int scheduledTotalCredit;

    private int actualTotalCredit;

    public int getGreaterTime() {
        return greaterTime;
    }

    public void setGreaterTime(final int greaterTime) {
        this.greaterTime = greaterTime;
    }

    public int getScheduledFlight() {
        return scheduledFlight;
    }

    public void setScheduledFlight(final int scheduledFlight) {
        this.scheduledFlight = scheduledFlight;
    }

    public int getActualFlight() {
        return actualFlight;
    }

    public void setActualFlight(final int actualFlight) {
        this.actualFlight = actualFlight;
    }

    public int getScheduledCredit() {
        return scheduledCredit;
    }

    public void setScheduledCredit(final int scheduledCredit) {
        this.scheduledCredit = scheduledCredit;
    }

    public int getActualCredit() {
        return actualCredit;
    }

    public void setActualCredit(final int actualCredit) {
        this.actualCredit = actualCredit;
    }

    public int getDeadheadCredit() {
        return deadheadCredit;
    }

    public void setDeadheadCredit(final int deadheadCredit) {
        this.deadheadCredit = deadheadCredit;
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

    @Override
    public String toString() {
        return "PayCreditDTO [greaterTime=" + greaterTime + ", scheduledFlight=" + scheduledFlight + ", actualFlight="
                + actualFlight + ", scheduledCredit=" + scheduledCredit + ", actualCredit=" + actualCredit
                + ", deadheadCredit=" + deadheadCredit + ", scheduledTotalCredit=" + scheduledTotalCredit
                + ", actualTotalCredit=" + actualTotalCredit + "]";
    }

}
