package org.jasonxiao.demo.exception.user;

import org.jasonxiao.demo.exception.ErrorType;
import org.jasonxiao.demo.exception.GenericException;

/**
 * Created by Jason on 2/3/16.
 */
public class UserNotFoundException extends GenericException {

    public UserNotFoundException() {
        super(ErrorType.USER_NOT_FOUND.getCode(), ErrorType.USER_NOT_FOUND.getDefaultMsg());
    }

    public UserNotFoundException(String message) {
        super(ErrorType.USER_NOT_FOUND.getCode(), message);
    }

}
