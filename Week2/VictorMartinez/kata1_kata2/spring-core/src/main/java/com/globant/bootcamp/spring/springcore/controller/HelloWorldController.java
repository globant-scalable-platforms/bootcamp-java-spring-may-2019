package com.globant.bootcamp.spring.springcore.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.globant.bootcamp.spring.springcore.business.Authenticator;
import com.globant.bootcamp.spring.springcore.data.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloWorldController {
    @Autowired
    DataSource dataSource;


    @GetMapping(value="/HelloWorld/{all}")
    public String printUsers(@PathVariable String all) {
        return "Hello World to the new Guests : "+dataSource.getAllUsers().toString();

    }


}











