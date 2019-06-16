package com.globant.bootcamp.springrest.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/date")
public class DateController {

    @GetMapping
    public ResponseEntity validateDates(@RequestParam(value = "from", required = true)
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                        @RequestParam(value = "to", required = true)
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        if(from.isAfter(to)) {
            throw new IllegalArgumentException();
        }

        return ResponseEntity.status(HttpStatus.OK).body("the date values are correct.");
    }
}

