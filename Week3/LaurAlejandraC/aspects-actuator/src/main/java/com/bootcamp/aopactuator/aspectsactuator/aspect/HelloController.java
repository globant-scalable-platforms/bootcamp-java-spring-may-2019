package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloFacade helloFacade;

    @Autowired
    public HelloController(HelloFacade helloFacade){
        this.helloFacade = helloFacade;
    }

    @GetMapping("/hello")
    public String getHello(){
        return helloFacade.execute();
    }
}
