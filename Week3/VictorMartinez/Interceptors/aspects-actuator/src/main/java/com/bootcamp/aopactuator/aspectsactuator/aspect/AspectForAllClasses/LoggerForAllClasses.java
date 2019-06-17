package com.bootcamp.aopactuator.aspectsactuator.aspect.AspectForAllClasses;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerForAllClasses {

  //  @Pointcut("within(com.bootcamp.aopactuator.aspectsactuator.aspect..*)")
  //  public void execute() { }


    @Pointcut("execution(* *(..)) && within(com.bootcamp.aopactuator.aspectsactuator.aspect..*)")
    public void execute() { }

    @Before("execute()")
    public void loggIn(){
        System.out.println(" ");
        System.out.println(" Before : Pause created by the ASPECT that affects all methods in packages");
        System.out.println(" ");
    }

    @After("execute()")
    public void loggOut(){
        System.out.println(" ");
        System.out.println("After : Pause created by the ASPECT that affects all methods in packages");
        System.out.println(" ");
    }

}
