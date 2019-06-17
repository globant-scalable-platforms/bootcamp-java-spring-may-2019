package com.bootcamp.aopactuator.aspectsactuator.aspect.Batch;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @Before("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Batch.Command.execute(..))")
    public void loggIn(){
        System.out.println("entro ");
    }

    @Before("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Greeting.GreetingInterface.Greeting(..))")
    public void logGreeting1(){ System.out.println("Hello Greeting Logger Simple 1");}

    @After("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Batch.Command.execute(..))")
    public void loggInAfter(){
        System.out.println("salio ");
    }

    @After("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Greeting.GreetingInterface.Greeting(..))")
    public void logGreeting2(){ System.out.println("BYe from Greeting Logger Simple 1");}

}
