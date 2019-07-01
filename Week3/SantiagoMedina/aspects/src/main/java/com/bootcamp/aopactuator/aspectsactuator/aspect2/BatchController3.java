package com.bootcamp.aopactuator.aspectsactuator.aspect2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController3 {


    private BatchFacade3 batchFacade3;

    @Autowired
    public BatchController3(BatchFacade3 batchFacade3) {
        this.batchFacade3 = batchFacade3;
    }

    @GetMapping("/batch3")
    public String executeBatch(){
        return batchFacade3.execute();
    }
}
