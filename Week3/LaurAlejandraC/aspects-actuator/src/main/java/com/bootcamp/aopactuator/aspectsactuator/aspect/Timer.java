package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Timer {
    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void execute(){}

    @Around("execute()")
    public String timer(ProceedingJoinPoint proceedingJoinPoint){
        long startTime = System.nanoTime();
        String result = "";

        try{
            result = (String) proceedingJoinPoint.proceed();
        }
        catch (Throwable throwable){
            System.out.println("Error: " + throwable.getMessage());
        }

        double totalElapsedTime = (System.nanoTime()-startTime) / 1000000.0;

        System.out.println("Total elapsed time: " + totalElapsedTime + "ms");

        return result;
    }
}
