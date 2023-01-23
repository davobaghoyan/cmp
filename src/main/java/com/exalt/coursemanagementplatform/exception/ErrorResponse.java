package com.exalt.coursemanagementplatform.exception;

/**
 * The ErrorResponse class represents a response with a message and status code.
 */
public class ErrorResponse {
    public String errorMessage;
    public int errorCode;

    public ErrorResponse(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
