package com.globant.bootcamp.spring.week2.challenges.controller;


import java.io.FileNotFoundException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.week2.challenges.business.Challenge3File;

@RestController
public class Challenge3FileController {
	
	@Autowired
	Challenge3File challenge3File;
	
    @GetMapping(value="/challenge3")
    public Map<String, Double> dates() throws FileNotFoundException {
    	
        return challenge3File.fileOperations();
        
    }

}
