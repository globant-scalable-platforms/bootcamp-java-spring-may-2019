package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.stereotype.Component;

@Component
public class BatchFacade2 implements Command2{

    public String execute() {
        return "Success";
    }
}