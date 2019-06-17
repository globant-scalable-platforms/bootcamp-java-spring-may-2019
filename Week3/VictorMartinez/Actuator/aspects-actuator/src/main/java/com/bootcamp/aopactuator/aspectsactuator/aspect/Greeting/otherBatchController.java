package com.bootcamp.aopactuator.aspectsactuator.aspect.Greeting;

import com.bootcamp.aopactuator.aspectsactuator.aspect.Greeting.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class otherBatchController {

    private Greeting greeting;

    @Autowired
    public otherBatchController(Greeting greeting){
        this.greeting = greeting;
    }

    @GetMapping("/greeting")
    public String greeting(){
        return this.greeting.Greeting();
    }


}
