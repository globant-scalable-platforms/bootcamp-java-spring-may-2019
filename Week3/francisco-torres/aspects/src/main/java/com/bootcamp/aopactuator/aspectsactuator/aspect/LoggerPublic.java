package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerPublic {

    @Before("within(com.bootcamp.aopactuator.aspectsactuator.aspect..*)")
    public void publicMethod(JoinPoint jp) {
        System.out.print("the '" + jp.getTarget().getClass().getSimpleName() + ".");
        System.out.println( jp.getSignature().getName() + "()' class was executed");
    }
}
