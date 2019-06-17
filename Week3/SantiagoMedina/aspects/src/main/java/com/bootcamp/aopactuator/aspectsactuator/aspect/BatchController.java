package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {


    private BatchFacade batchFacade;

    @Autowired
    public BatchController(BatchFacade batchFacade) {
        this.batchFacade = batchFacade;
    }

    @GetMapping("/batch")
    public String executeBatch(){
        return batchFacade.execute();
    }
}
