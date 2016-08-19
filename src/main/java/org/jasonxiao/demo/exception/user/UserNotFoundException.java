package org.jasonxiao.demo.exception.user;

import org.jasonxiao.demo.exception.ErrorType;
import org.jasonxiao.demo.exception.GenericException;

/**
 * @author Jason Xiao
 */
public class UserNotFoundException extends GenericException {

    public UserNotFoundException() {
        super(ErrorType.USER_NOT_FOUND.getCode(), ErrorType.USER_NOT_FOUND.getDefaultMsg());
    }

    public UserNotFoundException(String message) {
        super(ErrorType.USER_NOT_FOUND.getCode(), message);
    }

}
