/**
 *@author sivan
 *POJO to store modified normal sequence details from OpsHub Service
 */

package com.aa.entities.opshub;

public class OpenConverstionMode {
    private ModifyNormalSequence modifyNormalSequence;

    public ModifyNormalSequence getModifyNormalSequence() {
        return modifyNormalSequence;
    }

    public void setModifyNormalSequence(final ModifyNormalSequence modifyNormalSequence) {
        this.modifyNormalSequence = modifyNormalSequence;
    }

    @Override
    public String toString() {
        return "OpenConverstionMode [modifyNormalSequence=" + modifyNormalSequence + "]";
    }

}
