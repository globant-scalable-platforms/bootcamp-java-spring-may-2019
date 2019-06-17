package com.bootcamp.aopactuator.aspectsactuator.aspect.newController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class newController {

    private newControllerImpl newController;

    @Autowired
    public newController(newControllerImpl newControllerImpl){
        this.newController = newControllerImpl;
    }

    @GetMapping("/newController")
    public String newControllerMapping(){
        this.newController.newGreeting();
        return "new Controller Domain created succesfully";
    }


}
