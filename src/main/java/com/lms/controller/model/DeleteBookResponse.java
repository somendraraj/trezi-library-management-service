package com.lms.controller.model;

import com.lms.model.Status;

public class DeleteBookResponse {

    private Status status;
    private String message;

    public DeleteBookResponse(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
