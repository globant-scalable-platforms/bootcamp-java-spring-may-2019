package com.bootcamp.aopactuator.aspectsactuator.aspect2;

import org.springframework.stereotype.Component;

@Component
public class BatchFacade3 implements Command3{

    public String execute() {
        return "Success";
    }
}