package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Command2Controller {


    private Command2Facade command2Facade;

    @Autowired
    public Command2Controller(Command2Facade command2Facade) {
        this.command2Facade = command2Facade;
    }

    @GetMapping("/command2")
    public void executeCommand(){
        command2Facade.doSomething();
    }
}
