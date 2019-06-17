package com.bootcamp.aopactuator.aspectsactuator.aspect.newController;


import org.springframework.stereotype.Component;

@Component
public class newControllerImpl implements newControllerInterface {


    @Override
    public void newGreeting() {
        System.out.println("Just created the newController Void Method");
    }
}

