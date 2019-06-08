package main.java.springbootcamp.springrest.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
@ControllerAdvice
public class MyExceptionHandler {
 
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex){
        System.out.println("The Exception");
        return "Incorrect data. Check your input";
    }
}