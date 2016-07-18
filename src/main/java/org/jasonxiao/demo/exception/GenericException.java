package org.jasonxiao.demo.exception;

/**
 * Created by Jason on 2/5/16.
 */
public class GenericException extends Exception {

    protected int code = 9999;

    public GenericException(int code) {
        super("Generic Error");
        this.code = code;
    }

    public GenericException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
