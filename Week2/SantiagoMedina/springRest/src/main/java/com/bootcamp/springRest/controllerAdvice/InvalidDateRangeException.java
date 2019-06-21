package com.bootcamp.springRest.controllerAdvice;

public class InvalidDateRangeException extends Exception {

	public InvalidDateRangeException(String message) {
        super(message);
    }
	
}
