package org.jasonxiao.demo.exception;


public enum ErrorType {

    USER_NOT_FOUND(40401, "User is not found");

    private final int errorCode;
    private final String errorMessage;

    ErrorType(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return String.valueOf(this.errorCode) + ":" + this.errorMessage;
    }

}
