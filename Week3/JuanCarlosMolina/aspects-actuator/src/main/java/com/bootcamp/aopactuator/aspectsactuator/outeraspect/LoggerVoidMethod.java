package com.bootcamp.aopactuator.aspectsactuator.outeraspect;

import com.bootcamp.aopactuator.aspectsactuator.AspectsActuatorApplication;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerVoidMethod {

    private Logger LOG = LoggerFactory.getLogger(AspectsActuatorApplication.class);

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.endpoint.AspectController.delete())")
    public void delete() {  }

    @Around(value = "delete()")
    public void logVoidMethod(){
        LOG.info("com.bootcamp.aopactuator.aspectsactuator.aspect.endpoint.AspectController.delete() executed");
    }

}
