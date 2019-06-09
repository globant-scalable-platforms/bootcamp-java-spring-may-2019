package com.globant.bootcamp.spring.week2.challenges.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	   @ExceptionHandler(value = DateNotGreaterException.class)
	   public ResponseEntity<Object> exception(DateNotGreaterException exception) {
	      return new ResponseEntity<>("To date is NOT greater than from date", HttpStatus.EXPECTATION_FAILED);
	   }
}
