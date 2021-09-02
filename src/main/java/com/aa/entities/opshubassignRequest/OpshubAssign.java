/**
 *@author sivan
 *POJO to store opshub assignment details to OpsHub Service
 */

package com.aa.entities.opshubassignRequest;

public class OpshubAssign {
    private String employeeNumber;

    private String seat;

    private String sequenceNumber;

    private String sequenceOriginDate;

    private String reasonCode;

    // Getter Methods

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getSeat() {
        return seat;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public String getSequenceOriginDate() {
        return sequenceOriginDate;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    // Setter Methods

    public void setEmployeeNumber(final String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setSeat(final String seat) {
        this.seat = seat;
    }

    public void setSequenceNumber(final String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public void setSequenceOriginDate(final String sequenceOriginDate) {
        this.sequenceOriginDate = sequenceOriginDate;
    }

    public void setReasonCode(final String reasonCode) {
        this.reasonCode = reasonCode;
    }
}
