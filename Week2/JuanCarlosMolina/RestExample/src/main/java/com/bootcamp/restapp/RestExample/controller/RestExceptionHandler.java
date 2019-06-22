package com.bootcamp.restapp.RestExample.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DateTimeParseException.class})
    protected ResponseEntity<Object> handleBadFormat(RuntimeException ex, WebRequest request) {

        String bodyOfResponse = "Invalid date format. Date must be in dd-mm-yyyy format";

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {InvalidDateRangeException.class})
    protected ResponseEntity<Object> handleBadRange(RuntimeException ex, WebRequest request) {

        String bodyOfResponse = "Invalid date range. Date 'to' must be greater than Date 'from'";

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
