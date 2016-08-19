package org.jasonxiao.demo.exception;

import org.jasonxiao.demo.exception.user.UserNotFoundException;

/**
 * Created by Jason on 2/5/16.
 */
public class GenericException extends Exception {

    private int code;

    public GenericException() {
        super("Generic Exception");
        this.code = -1;
    }

    public GenericException(int code) {
        super("Generic Exception");
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
