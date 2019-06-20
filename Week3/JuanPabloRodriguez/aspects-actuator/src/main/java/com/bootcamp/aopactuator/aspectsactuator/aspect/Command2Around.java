package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Command2Around {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command2.doSomething(..))")
    public void doSomething() {  }


    @Around( value = "doSomething()")
    public void doAround(ProceedingJoinPoint jp){
        System.out.println("Around In");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("Around Out");
    }
}
