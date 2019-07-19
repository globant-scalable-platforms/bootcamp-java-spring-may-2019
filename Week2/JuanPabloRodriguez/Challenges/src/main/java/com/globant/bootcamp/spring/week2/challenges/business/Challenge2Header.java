package com.globant.bootcamp.spring.week2.challenges.business;


import org.springframework.http.ResponseEntity;

public interface Challenge2Header {
	
    public ResponseEntity<String> validateHeader(final String headerValue);

}
