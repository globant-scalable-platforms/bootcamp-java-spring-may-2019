package com.bootcamp.aopactuator.aspectsactuator.aspect.newController;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@Aspect
public class newControllerWithoutPointCut {

    @Before("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.newController.newControllerImpl.newGreeting(..))")
    public void loggIn(){
        System.out.println("newController entered without PointCut ");
    }

    @After("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.newController.newControllerImpl.newGreeting(..))")
    public void logGreeting1(){ System.out.println("newController entered without PointCut");}



}
