package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerWTF {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.BatchFacade.wtf(..))")
    public void execute() {  }

    @Before("execute()")
    public void loggIn(){
        System.out.println("entro a WTF?");
    }

    @After("execute()")
    public void loggInAfter(){
        System.out.println("salio de WTF?");
    }
}
