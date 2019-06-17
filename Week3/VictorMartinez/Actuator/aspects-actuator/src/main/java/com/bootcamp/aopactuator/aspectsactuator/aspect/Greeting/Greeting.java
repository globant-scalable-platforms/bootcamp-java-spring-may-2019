package com.bootcamp.aopactuator.aspectsactuator.aspect.Greeting;


import org.springframework.stereotype.Component;

@Component
public class Greeting implements GreetingInterface {

    @Override
    public String Greeting(){
        return("Hey you all");
    }

}
