package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.stereotype.Component;

@Component
public class BatchFacade implements Command{

    public String execute() {
        return "Success";
    }

    @Override
    public String secondExecute() {
        return "Success with secondExecute";
    }
}
