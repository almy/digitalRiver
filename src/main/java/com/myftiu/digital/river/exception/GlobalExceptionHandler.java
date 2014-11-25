package com.myftiu.digital.river.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by myftiu
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PerfectNumberException.class)
    public @ResponseBody PerfectNumberError handleSQLException(HttpServletRequest request, Exception ex){
        logger.info("an error {} occurred in {}", ex.getMessage(), request.getRequestURL());
        return new PerfectNumberError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public @ResponseBody PerfectNumberError handleIOException(Exception ex){
        logger.error("An exception {} happened", ex.getMessage() );
        return new PerfectNumberError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), ex.getMessage());

    }
}
