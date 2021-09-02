/**
 * @author rswami
 * POJO to get service qualification details from CCS service
 */

package com.aa.entities.ccsResponse;

public class ServiceQuals {

    private int number;

    private String description;

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ServiceQuals [number=" + number + ", description=" + description + "]";
    }

}
