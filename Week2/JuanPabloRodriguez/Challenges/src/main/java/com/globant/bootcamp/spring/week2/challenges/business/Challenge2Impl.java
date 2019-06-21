package com.globant.bootcamp.spring.week2.challenges.business;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class Challenge2Impl implements Challenge2Header {

	public ResponseEntity<String> validateHeader(String headerValue) {
		if (headerValue.equals("admin")) {
			return new ResponseEntity<>("CORRECT Header", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("INCORRECT Header", HttpStatus.FORBIDDEN);

		}
	}

}
