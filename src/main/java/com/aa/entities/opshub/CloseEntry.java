/**
 *@author sivan
 *POJO to store close entry details from OpsHub Service
 */

package com.aa.entities.opshub;

public class CloseEntry {

    private CloseMode closeMode;

    public CloseMode getCloseMode() {
        return closeMode;
    }

    public void setCloseMode(final CloseMode closeMode) {
        this.closeMode = closeMode;
    }

    @Override
    public String toString() {
        return "CloseEntry [closeMode=" + closeMode + "]";
    }

}
