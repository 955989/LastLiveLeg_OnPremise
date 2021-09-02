/**
 * @author rswami
 * POJO to get contractual month details from CCS service
 **/

package com.aa.entities.ccsResponse;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ContractualMonthResponseEntity {

    @JsonAlias({ "airlineCode" })
    private String airlineCode;

    @JsonAlias({ "contractMonth" })
    private String contractMonth;

    @JsonAlias({ "type" })
    private String type;

    @JsonAlias({ "startDate" })
    private String startDate;

    @JsonAlias({ "endDate" })
    private String endDate;

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

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

}
