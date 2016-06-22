package org.jasonxiao.demo.exception;

/**
 * Created by Jason on 2/3/16.
 */
public class UserNotFoundException extends GeneralException {


    public UserNotFoundException() {
        super(ErrorType.USER_NOT_FOUND.getErrorCode(), ErrorType.USER_NOT_FOUND.getErrorMessage());
    }

    public UserNotFoundException(String message) {
        super(ErrorType.USER_NOT_FOUND.getErrorCode(), message);
    }

}
