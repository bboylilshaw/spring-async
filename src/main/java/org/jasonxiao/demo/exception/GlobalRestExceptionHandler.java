package org.jasonxiao.demo.exception;


import org.jasonxiao.demo.exception.user.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jason on 7/28/16.
 */
@RestControllerAdvice
public class GlobalRestExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalRestExceptionHandler.class);

    @ExceptionHandler(GenericException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo handleGenericException(HttpServletRequest request, GenericException ex){
        logger.error("Caught Exception: {}", ex.getClass().getName(), ex);
        return new ErrorInfo.Builder()
                .setCode(ex.getCode())
                .setMessage(ex.getMessage())
                .setException(ex.getClass().getName())
                .setPath(request.getRequestURI())
                .build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorInfo handleResourceNotFoundException(HttpServletRequest request, GenericException ex){
        logger.error("Caught Exception: {}", ex.getClass().getName(), ex);
        return new ErrorInfo.Builder()
                .setStatus(HttpStatus.NOT_FOUND)
                .setCode(ex.getCode())
                .setMessage(ex.getMessage())
                .setException(ex.getClass().getName())
                .setPath(request.getRequestURI())
                .build();
    }
}
