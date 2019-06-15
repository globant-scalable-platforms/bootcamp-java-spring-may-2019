package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.stereotype.Component;

@Component
public class HelloFacade implements Command {

    public String execute() {
        return "Hello";
    }
}
