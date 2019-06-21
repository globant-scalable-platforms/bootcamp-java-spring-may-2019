package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.stereotype.Component;

@Component
public class Command2Facade implements Command2{

    public void doSomething() {
        System.out.println("Doing something");
    }
}
