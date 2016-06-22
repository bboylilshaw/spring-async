package org.jasonxiao.demo.exception;

/**
 * Created by Jason on 2/5/16.
 */
public class GeneralException extends Exception {

    protected int code;

    public GeneralException(int code) {
        super("General Error");
        this.code = code;
    }

    public GeneralException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
