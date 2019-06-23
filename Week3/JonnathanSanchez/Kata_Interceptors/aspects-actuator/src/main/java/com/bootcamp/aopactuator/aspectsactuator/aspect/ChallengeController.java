package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {

    @Autowired
    private BatchFacade batchFacade;

    @GetMapping("/printer")
    public String executePrint(){
            batchFacade.printer();
        return "Print success";
    }
}
