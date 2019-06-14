package com.bootcamp.aopactuator.aspectsactuator.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerTime {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void execute() {  }


    @Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
        long start = System.nanoTime();
        String value ="";
        try {
            value =  (String) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        long end = System.nanoTime();
        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        return value;
    }
}