package com.bootcamp.restapp.RestExample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class DateController {

    @GetMapping("/dates/from/{from}/to/{to}")
    public ResponseEntity<Boolean> compareDates(@PathVariable("from") String fromDate,
                                                @PathVariable("to") String toDate){

        LocalDate dateFrom = parseDate(fromDate);

        LocalDate dateTo = parseDate(toDate);

        if(dateFrom.isBefore(dateTo)){
            return new ResponseEntity<>(new Boolean("true"), HttpStatus.OK);
        }

        throw new InvalidDateRangeException();
    }

    private LocalDate parseDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }
}
