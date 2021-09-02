/**
 *@author sivan
 *POJO to store modify request from OpsHub Service
 */

package com.aa.entities.opshub;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModRequests {
    @JsonProperty("common")
    private CommonPartition commonpartiotion;

    @JsonProperty("open")
    private OpenConverstionMode openConverstionMode;

    @JsonProperty("add")
    private List<AddLeg> addleg;

    @JsonProperty("delete")
    private List<DeleteLeg> deleteleg;

    @JsonProperty("close")
    private CloseEntry closeentry;

    private String endTransaction;

    public CommonPartition getCommonpartiotion() {
        return commonpartiotion;
    }

    public void setCommonpartiotion(final CommonPartition commonpartiotion) {
        this.commonpartiotion = commonpartiotion;
    }

    public OpenConverstionMode getOpenConverstionMode() {
        return openConverstionMode;
    }

    public void setOpenConverstionMode(final OpenConverstionMode openConverstionMode) {
        this.openConverstionMode = openConverstionMode;
    }

    public List<AddLeg> getAddleg() {
        return addleg;
    }

    public void setAddleg(final List<AddLeg> addleg) {
        this.addleg = addleg;
    }

    public List<DeleteLeg> getDeleteleg() {
        return deleteleg;
    }

    public void setDeleteleg(final List<DeleteLeg> deleteleg) {
        this.deleteleg = deleteleg;
    }

    public CloseEntry getCloseentry() {
        return closeentry;
    }

    public void setCloseentry(final CloseEntry closeentry) {
        this.closeentry = closeentry;
    }

    public String getEndTransaction() {
        return endTransaction;
    }

    public void setEndTransaction(final String endTransaction) {
        this.endTransaction = endTransaction;
    }

    @Override
    public String toString() {
        return "ModRequests [commonpartiotion=" + commonpartiotion + ", openConverstionMode=" + openConverstionMode
                + ", addleg=" + addleg + ", deleteleg=" + deleteleg + ", closeentry=" + closeentry + ", endTransaction="
                + endTransaction + "]";
    }

}
