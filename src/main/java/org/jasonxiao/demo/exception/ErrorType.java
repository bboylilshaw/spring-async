package org.jasonxiao.demo.exception;


public enum ErrorType {

    /*
     * User errors
     */
    USER_NOT_FOUND(1001, "User is not found"),
    USER_ALREADY_EXIST(1002, "User already exist");

    private final int code;
    private final String defaultMsg;

    ErrorType(int code, String defaultMsg) {
        this.code = code;
        this.defaultMsg = defaultMsg;
    }

    public int getCode() {
        return code;
    }

    public String getDefaultMsg() {
        return defaultMsg;
    }

    @Override
    public String toString() {
        return "ErrorType{" +
                "code=" + code +
                ", defaultMsg='" + defaultMsg + '\'' +
                '}';
    }
}
