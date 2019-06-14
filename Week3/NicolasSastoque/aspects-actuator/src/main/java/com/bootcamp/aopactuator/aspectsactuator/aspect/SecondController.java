package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {


    private BatchFacade batchFacade;

    @Autowired
    public SecondController(BatchFacade batchFacade) {
        this.batchFacade = batchFacade;
    }

    @GetMapping("/second")
    public String executeBatch(){
        return batchFacade.secondExecute();
    }
}
