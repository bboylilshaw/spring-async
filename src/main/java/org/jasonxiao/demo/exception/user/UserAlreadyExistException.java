package org.jasonxiao.demo.exception.user;

import org.jasonxiao.demo.exception.ErrorType;
import org.jasonxiao.demo.exception.GenericException;

/**
 * @author Jason Xiao
 */
public class UserAlreadyExistException extends GenericException {

    public UserAlreadyExistException() {
        super(ErrorType.USER_ALREADY_EXIST.getCode(), ErrorType.USER_ALREADY_EXIST.getDefaultMsg());
    }

    public UserAlreadyExistException(String message) {
        super(ErrorType.USER_ALREADY_EXIST.getCode(), message);
    }
}
