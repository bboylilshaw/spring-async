package org.jasonxiao.demo.exception.user;

import org.jasonxiao.demo.exception.ErrorType;
import org.jasonxiao.demo.exception.GenericException;

/**
 * Created by Jason on 7/17/16.
 */
public class UserAlreadyExistException extends GenericException {

    public UserAlreadyExistException() {
        super(ErrorType.USER_ALREADY_EXIST.getCode(), ErrorType.USER_ALREADY_EXIST.getDefaultMsg());
    }

    public UserAlreadyExistException(String message) {
        super(ErrorType.USER_ALREADY_EXIST.getCode(), message);
    }
}
