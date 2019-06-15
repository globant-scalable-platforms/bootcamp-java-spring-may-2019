package com.bootcamp.aopactuator.aspectsactuator.aspect;

import com.bootcamp.aopactuator.aspectsactuator.aspect.otherPackage.CR7Celebration;
import com.bootcamp.aopactuator.aspectsactuator.aspect.otherPackage.MessiCelebration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {


    private BatchFacade batchFacade;
    private MessiCelebration messiFacade;
    private CR7Celebration cr7Facade;

    @Autowired
    public BatchController(BatchFacade batchFacade, MessiCelebration messiFacade, CR7Celebration cr7Facade) {
        this.batchFacade = batchFacade;
        this.messiFacade = messiFacade;
        this.cr7Facade = cr7Facade;
    }

    @GetMapping("/batch")
    public String executeBatch(){
        return batchFacade.execute();
    }
    
    @GetMapping("/wtf")
    public String executeBatchWTF(){
        batchFacade.wtf();
        return "Wtf?";
    }
    
    @GetMapping("/otherPackage/messi")
    public String otherPackage10(){
        return messiFacade.celebrate();
    }
    
    @GetMapping("/otherPackage/cr7")
    public String otherPackage7(){
        return cr7Facade.celebrate();
    }


}
