package com.bootcamp.springRest.controllerAdvice;

public class StudentNotFoundException extends Exception{
	
	public StudentNotFoundException(String message) {
        super(message);
    }
	
}
