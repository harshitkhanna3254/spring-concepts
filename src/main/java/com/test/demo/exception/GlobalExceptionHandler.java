package com.test.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNoSuchElementFoundException(NoSuchElementFoundException noSuchElementFoundException, WebRequest webRequest) {
        log.error("Failed to find the requested element", noSuchElementFoundException);
        return buildErrorResponse(noSuchElementFoundException,HttpStatus.NOT_FOUND, webRequest);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(Exception exception, HttpStatus httpStatus, WebRequest webRequest) {
        return buildErrorResponse(exception, exception.getMessage(), httpStatus, webRequest);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(Exception exception, String message, HttpStatus httpStatus, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
        errorResponse.setStackTrace(ExceptionUtils.getStackTrace(exception));
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

}
