package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController2 {


    private BatchFacade2 batchFacade2;

    @Autowired
    public BatchController2(BatchFacade2 batchFacade2) {
        this.batchFacade2 = batchFacade2;
    }

    @GetMapping("/batch2")
    public String executeBatch(){
        return batchFacade2.execute();
    }
}
