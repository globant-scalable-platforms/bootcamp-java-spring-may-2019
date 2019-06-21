package com.globant.bootcamp.spring.week2.challenges.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.week2.challenges.business.Challenge1Date;

@RestController
public class Challenge1DatesController {
	
	@Autowired
	Challenge1Date challenge1Date;
	
    @GetMapping(value="/challenge1/{from_date}/{to_date}")
    public boolean dates(@PathVariable String from_date, @PathVariable String to_date) throws ParseException {
    	String format = "dd-MM-yyyy";
        Date from_date_d=new SimpleDateFormat(format).parse(from_date); 
        Date to_date_d=new SimpleDateFormat(format).parse(to_date);  

        return challenge1Date.greaterDate(from_date_d, to_date_d);
        
    }

}
