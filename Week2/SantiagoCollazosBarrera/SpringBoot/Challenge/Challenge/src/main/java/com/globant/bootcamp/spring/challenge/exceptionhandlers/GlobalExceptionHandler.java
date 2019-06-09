/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.spring.challenge.exceptionhandlers;

import java.util.Date;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 *
 * @author Santiago Collazos Barrera
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    //@ExceptionHandler({IllegalArgumentException.class})
    @ExceptionHandler({ConversionFailedException.class})
    protected ResponseEntity<Object> handleAllException (ConversionFailedException ex){        
        ConversionFailedException conversion = new ConversionFailedException(new Date(),ex.getMessage());
        System.out.println("Controlando situacion");
        return new ResponseEntity(conversion,HttpStatus.BAD_REQUEST);
    }
}

