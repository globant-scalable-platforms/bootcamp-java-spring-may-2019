package com.bootcamp.aopactuator.aspectsactuator.aspect.newController;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class newControllerPointCut {

    //@Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Batch.Command.execute(..))")

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.newController.newControllerImpl.newGreeting(..))")
    public void execute() { }

    @Before("execute()")
    public void loggIn(){
        System.out.println("newController entro 2");
    }

    @After("execute()")
    public void loggInAfter(){
        System.out.println("newController salio 2");
    }
}
