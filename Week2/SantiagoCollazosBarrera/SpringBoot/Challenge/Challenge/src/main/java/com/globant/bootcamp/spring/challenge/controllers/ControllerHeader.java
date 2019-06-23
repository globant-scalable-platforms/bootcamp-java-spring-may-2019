/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.spring.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santiago Collazos Barrera
 */
@RestController()
@RequestMapping("/header")
public class ControllerHeader {
    
    private final static String ROLE = "admin";
    
    @GetMapping
    public ResponseEntity validateHeader(@RequestHeader("roles") String role){
        String roleHeader = role;
        if(roleHeader.equals(ROLE)){
            return ResponseEntity.status(HttpStatus.OK).body("Header validated");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Header invalidated");
            
    }
    
}
