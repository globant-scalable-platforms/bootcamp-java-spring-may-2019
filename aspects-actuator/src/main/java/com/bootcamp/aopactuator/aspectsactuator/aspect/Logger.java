package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {


    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void delete() {  }

    @Before("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void loggIn(){
        System.out.println("entró ");
    }

    @After("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void loggInAfter(){
        System.out.println("salió ");
    }


}
