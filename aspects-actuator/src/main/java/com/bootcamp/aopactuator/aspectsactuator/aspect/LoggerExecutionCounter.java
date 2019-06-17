package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerExecutionCounter {

    @Pointcut("execution(* Command.execute(..))")
    public void execute() {  }

    @Around(value = "execute()")
    public void measureExecutionTime(ProceedingJoinPoint jp){

        long startTime = System.nanoTime();

        try {
            jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error: " + throwable.getMessage());
        }

        long endTime = System.nanoTime();

        long elapsedTime= (endTime - startTime)/1000;

        System.out.println("execution done in " + elapsedTime + " μs. (Same package).");
    }
}
