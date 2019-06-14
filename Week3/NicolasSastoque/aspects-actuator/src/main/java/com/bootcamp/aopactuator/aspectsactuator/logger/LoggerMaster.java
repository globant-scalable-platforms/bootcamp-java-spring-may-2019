package com.bootcamp.aopactuator.aspectsactuator.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerMaster {

    // apply to all classes in aspect package
    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect..*(..))")
    public void execute() {  }


    @Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
        System.out.println("Log Master say in!");
        String value ="";
        try {
            value =  (String) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("Log Master say out!");

        return value;
    }
}
