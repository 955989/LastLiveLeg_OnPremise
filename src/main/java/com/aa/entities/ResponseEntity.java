/**
 * @author ugoudar
 * Pojo class to store LLL trade response
 */

package com.aa.entities;

public class ResponseEntity {

    private String status;

    private String response;

    public ResponseEntity(final String status, final String response) {
        super();
        this.status = status;
        this.response = response;
    }

    public ResponseEntity() {

    }

    @Override
    public String toString() {
        return "Response [status=" + status + ", sequence=" + response + "]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(final String response) {
        this.response = response;
    }

}
