package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAroundTimer {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void execute() {  }


    @Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
        Long begins = System.currentTimeMillis();
        String value ="";
        try {
            value =  (String) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        Long ends = System.currentTimeMillis();
        System.out.println("Execution Time(milliseconds): "+(ends-begins));
        return value;
    }
}
