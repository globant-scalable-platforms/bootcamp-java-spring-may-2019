package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggerTimer {

    //Match all classes in a package
    @Pointcut("within(com.bootcamp.aopactuator.aspectsactuator.aspect..*)")
    public void matchAllClasses() {  }

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void execute() {  }

    @Around( value = "execute()")
    public String loggerTiming(ProceedingJoinPoint jp){
        long start = System.nanoTime();
        String value ="";
        try {
            value =  (String) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        long end = System.nanoTime();

        System.out.println("Execution time: " +  ((end - start)/1000000.0) + "ms");
        return value;
    }
}
