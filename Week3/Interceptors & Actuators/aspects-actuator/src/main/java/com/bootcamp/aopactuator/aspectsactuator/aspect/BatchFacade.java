package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.stereotype.Component;

@Component
public class BatchFacade implements Command{

    public String execute() {
        return "Success";
    }

    public void wtf(){
        System.out.println("WTF?");
    }
}
