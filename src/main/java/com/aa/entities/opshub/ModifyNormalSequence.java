/**
 *@author sivan
 *POJO to store credentials details from OpsHub Service
 */

package com.aa.entities.opshub;

public class ModifyNormalSequence {
    private String seqNum;

    private String seqOrgDate;

    private String addReasonCode;

    private String removeReasonCode;

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(final String seqNum) {
        this.seqNum = seqNum;
    }

    public String getSeqOrgDate() {
        return seqOrgDate;
    }

    public void setSeqOrgDate(final String seqOrgDate) {
        this.seqOrgDate = seqOrgDate;
    }

    public String getAddReasonCode() {
        return addReasonCode;
    }

    public void setAddReasonCode(final String addReasonCode) {
        this.addReasonCode = addReasonCode;
    }

    public String getRemoveReasonCode() {
        return removeReasonCode;
    }

    public void setRemoveReasonCode(final String removeReasonCode) {
        this.removeReasonCode = removeReasonCode;
    }

    @Override
    public String toString() {
        return "ModifyNormalSequence [seqNum=" + seqNum + ", seqOrgDate=" + seqOrgDate + ", addReasonCode="
                + addReasonCode + ", removeReasonCode=" + removeReasonCode + "]";
    }

}
