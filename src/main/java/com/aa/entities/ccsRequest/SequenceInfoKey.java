/**
 *@author rswami
* POJO to store Sequence details request to CCS service
*/

package com.aa.entities.ccsRequest;

public class SequenceInfoKey {
    private String airlineCode;

    private String contractMonth;

    private String originationDate;

    private String position;

    private String sequenceNumber;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(final String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(final String contractMonth) {
        this.contractMonth = contractMonth;
    }

    public String getOriginationDate() {
        return originationDate;
    }

    public void setOriginationDate(final String originationDate) {
        this.originationDate = originationDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(final String position) {
        this.position = position;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(final String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public String toString() {
        return "SequenceInfoKey [airlineCode=" + airlineCode + ", contractMonth=" + contractMonth + ", originationDate="
                + originationDate + ", position=" + position + ", sequenceNumber=" + sequenceNumber + "]";
    }

}
