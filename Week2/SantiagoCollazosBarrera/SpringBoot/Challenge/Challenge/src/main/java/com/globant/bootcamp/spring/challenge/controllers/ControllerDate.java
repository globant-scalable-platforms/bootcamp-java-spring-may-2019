/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.spring.challenge.controllers;

import com.globant.bootcamp.spring.challenge.exceptionhandlers.ConversionFailedException;
import com.globant.bootcamp.spring.challenge.exceptionhandlers.GlobalExceptionHandler;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santiago Collazos Barrera
 */
@RestController()
@RequestMapping("/validate")
public class ControllerDate {

    @GetMapping("/date")
    public ResponseEntity validateDate(@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") @Valid Date to, @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") @Valid Date from) throws ConversionFailedException{      
        return ResponseEntity.status(HttpStatus.OK).body(to.after(from));
    }

}
