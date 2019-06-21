package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggerPointCut {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void execute() {  }

    @Before("execute()")
    public void loggIn(){
        System.out.println("entro 2");
    }

    @After("execute()")
    public void loggInAfter(){
        System.out.println("salio 2");
    }
}
