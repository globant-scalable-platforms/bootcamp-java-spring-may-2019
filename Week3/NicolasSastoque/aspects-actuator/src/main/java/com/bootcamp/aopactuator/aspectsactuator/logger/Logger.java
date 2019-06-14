package com.bootcamp.aopactuator.aspectsactuator.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @Before("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void loggIn(){
        System.out.println("entro ");
    }

    @After("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void loggInAfter(){
        System.out.println("salio ");
    }


}
