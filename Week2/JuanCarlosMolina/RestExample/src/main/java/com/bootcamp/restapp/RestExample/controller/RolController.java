package com.bootcamp.restapp.RestExample.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class RolController {

    @RequestMapping("/admin")
    public ResponseEntity<String> validateAccess(@RequestHeader HttpHeaders headers){

        boolean accessGranted = headers.get("name").contains("roles") &&
                                headers.get("role").contains("admin");


        if(accessGranted){
            return new ResponseEntity<>("Access granted", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>("Access denied", HttpStatus.FORBIDDEN);
    }
}
