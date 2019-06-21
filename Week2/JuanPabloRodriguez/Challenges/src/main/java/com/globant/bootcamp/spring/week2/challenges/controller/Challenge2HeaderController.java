package com.globant.bootcamp.spring.week2.challenges.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.week2.challenges.business.Challenge2Header;

@RestController
public class Challenge2HeaderController {
	
	@Autowired
	Challenge2Header challenge2Header;

	@GetMapping(value = "/challenge2")
	public ResponseEntity<String> validateHeader(@RequestHeader("roles") String headerValue) {

		return challenge2Header.validateHeader(headerValue);

	}

}
