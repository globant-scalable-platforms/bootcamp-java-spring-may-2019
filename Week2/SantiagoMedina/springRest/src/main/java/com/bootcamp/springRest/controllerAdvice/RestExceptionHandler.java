package com.bootcamp.springRest.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFound(StudentNotFoundException ex){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidDateRangeException.class)
	public final ResponseEntity<Object> handleInvalidDateRange(InvalidDateRangeException ex){
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public final ResponseEntity<Object> handleMissingRequestHeader(MissingRequestHeaderException ex){
		ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.UNAUTHORIZED);
	}

}