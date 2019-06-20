package davidAcuna.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import davidAcuna.domain.ExcepcionResponse;
import davidAcuna.exceptions.BadRangeOfDatesException;

@RestControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BadRangeOfDatesException.class)
	public ResponseEntity<ExcepcionResponse> handleBadRangeOfDatesException(BadRangeOfDatesException ex) throws Exception{
		ExcepcionResponse excepcionResponse = new ExcepcionResponse(new Date(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(excepcionResponse);
	}	

}
