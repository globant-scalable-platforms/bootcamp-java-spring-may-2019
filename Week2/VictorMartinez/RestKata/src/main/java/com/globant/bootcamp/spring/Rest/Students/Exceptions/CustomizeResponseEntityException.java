package com.globant.bootcamp.spring.Rest.Students.Exceptions;

import com.globant.bootcamp.spring.Rest.Roles.Exception.ExceptionResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;



@ControllerAdvice
@RestController
public class CustomizeResponseEntityException extends ResponseEntityExceptionHandler {

   @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlerAllExceptions(Exception ex, WebRequest request) throws Exception{

        ExceptionResponses exceptionResponse = new ExceptionResponses(new Date(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) throws Exception{
        ExceptionResponses exceptionResponses =new ExceptionResponses(new Date(), ex.getMessage(),
                request.getDescription((false)));
        return new ResponseEntity<>(exceptionResponses, HttpStatus.FORBIDDEN);
    }
}
