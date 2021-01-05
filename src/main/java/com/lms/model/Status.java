package com.lms.model;

public enum Status {

    SUCCESS("Success"), FAILED("Failed"), UNKNOWN("Unknown"), NOT_FOUND("Not Found"), BAD_REQUEST("Bad Request");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus(String status) {
        return this.status;
    }
}
