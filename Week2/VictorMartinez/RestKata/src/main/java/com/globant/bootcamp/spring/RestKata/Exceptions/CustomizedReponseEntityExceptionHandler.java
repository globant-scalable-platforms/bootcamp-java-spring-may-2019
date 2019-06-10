package com.globant.bootcamp.spring.RestKata.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.format.DateTimeParseException;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedReponseEntityExceptionHandler {

    @ExceptionHandler (DateTimeParseException.class)
    public final ResponseEntity<errorDetails> handleBadArgumentFormatException(DateTimeParseException ex, WebRequest request)
    {
        errorDetails ErrorDetails = new errorDetails(new Date(), "Bad Input Arguments. Try the yyyy-mm-dd format", request.getDescription(false));
        return  new ResponseEntity<>(ErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
