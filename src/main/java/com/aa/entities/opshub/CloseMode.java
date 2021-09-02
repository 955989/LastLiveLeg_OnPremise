/**
 *@author sivan
 *POJO to store close mode details from OpsHub Service
 */

package com.aa.entities.opshub;

public class CloseMode {

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(final String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "CloseMode [position=" + position + "]";
    }

}
