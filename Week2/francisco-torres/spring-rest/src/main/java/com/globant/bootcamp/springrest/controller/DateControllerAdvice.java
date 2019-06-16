package com.globant.bootcamp.springrest.controller;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice(assignableTypes = DateController.class)
public class DateControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity IllegalArgumentException(final IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("the 'from' date is after the 'to' date.");
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity ConversionFailedException(final ConversionFailedException e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("the date values should be in ISO format.");
    }
}
