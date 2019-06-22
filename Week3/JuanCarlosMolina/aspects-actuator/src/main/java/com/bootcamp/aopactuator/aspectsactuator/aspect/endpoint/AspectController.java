package com.bootcamp.aopactuator.aspectsactuator.aspect.endpoint;

import com.bootcamp.aopactuator.aspectsactuator.AspectsActuatorApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AspectController {

    private Logger LOG = LoggerFactory.getLogger(AspectsActuatorApplication.class);

    @DeleteMapping("/aspects/{id}")
    public void delete(){
        LOG.warn("TODO delete element from collection");
    }


}
