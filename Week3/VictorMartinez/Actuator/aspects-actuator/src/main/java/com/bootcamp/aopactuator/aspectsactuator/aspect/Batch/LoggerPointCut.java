package com.bootcamp.aopactuator.aspectsactuator.aspect.Batch;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerPointCut {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Batch.Command.execute(..))")
    public void execute() { }


    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Greeting.GreetingInterface.Greeting(..))")
    public void executeGreeting() { }

    @Before("executeGreeting()")
    public void loggGreetingIn(){
        System.out.println("Greeting from Logger Point Cut 1");
    }

    @After("executeGreeting()")
    public void loggGretingOut(){ System.out.println("Bye from Logger Point Cut 1");}

    @Before("execute()")
    public void loggIn(){
        System.out.println("entro 2");
    }

    @After("execute()")
    public void loggInAfter(){
        System.out.println("salio 2");
    }
}
