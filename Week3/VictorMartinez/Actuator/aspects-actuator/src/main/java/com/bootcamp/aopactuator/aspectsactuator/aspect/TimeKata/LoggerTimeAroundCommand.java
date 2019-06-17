package com.bootcamp.aopactuator.aspectsactuator.aspect.TimeKata;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.lang.System.*;
@Aspect
@Component
public class LoggerTimeAroundCommand {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Batch.Command.execute(..))")
    public void execute() {  }



    @Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
        Long actualTime = System.currentTimeMillis();
        String value ="";
        try {
            value =  (String) jp.proceed();

        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("Around Out");
        System.out.println("Initial Time " + actualTime + " miliseconds" );
        System.out.println("Ending Time " + endTime + " miliseconds" );
        System.out.println("Total amount of Time for Execute Command " + (endTime - actualTime) + " miliseconds");
        return value;
    }

}
