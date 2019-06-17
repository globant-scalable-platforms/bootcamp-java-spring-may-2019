package com.bootcamp.aopactuator.aspectsactuator.aspect.AspectForAllClasses;

import com.bootcamp.aopactuator.aspectsactuator.aspect.Greeting.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllClassesInPackageController {

    private Greeting greeting;

    @Autowired
    public  AllClassesInPackageController(Greeting greeting){
        this.greeting = greeting;
    }

    @GetMapping("/allClasses")
    public String allClasses(){
        greeting.Greeting();
        return "Testing all Packages in Classes " + "Also using Greeting for activating the Aspect";
    }


}
