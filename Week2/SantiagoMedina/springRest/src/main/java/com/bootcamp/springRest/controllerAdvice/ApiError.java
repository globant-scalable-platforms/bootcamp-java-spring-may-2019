package com.bootcamp.springRest.controllerAdvice;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
	private Date timestamp;
	private String message;
	
	public ApiError(HttpStatus notFound, String string) {
		this.status = notFound;
		this.message = string;
		this.timestamp = new Date();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
