package com.bootcamp.aopactuator.aspectsactuator.aspect.Batch;

import org.springframework.stereotype.Component;

@Component
public class BatchFacade implements Command {

    public String execute() {
        return("Success");
    }
}
