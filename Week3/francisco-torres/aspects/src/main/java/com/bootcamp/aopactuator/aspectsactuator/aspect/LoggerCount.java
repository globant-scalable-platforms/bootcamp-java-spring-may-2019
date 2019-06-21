package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class LoggerCount {

    private int counter;

    public LoggerCount() {
        this.counter = 0;
    }

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void execute() {  }

    @Around(value = "execute()")
    public void countExecution(ProceedingJoinPoint jp) {
        String value = "";
        try {
            value =  (String) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("execute() call #" + ++counter);
    }
}
