package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerCelebrations {

    @Pointcut("within(com.bootcamp.aopactuator.aspectsactuator.aspect.otherPackage..*)")
    public void execute() {  }

    @Before("execute()")
    public void loggIn(){
        System.out.println("entro OtherPackage");
    }

    @After("execute()")
    public void loggInAfter(){
        System.out.println("salio OtherPackage");
    }
}
