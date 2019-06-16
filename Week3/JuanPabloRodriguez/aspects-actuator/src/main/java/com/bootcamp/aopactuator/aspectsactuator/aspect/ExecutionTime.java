package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExecutionTime {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.execute(..))")
    public void execute() {  }


    @Around( value = "execute()")
    public String timeExc(ProceedingJoinPoint jp){
        System.out.println("Around In");
        String value ="";
        long start = System.nanoTime();
        try {
            value =  (String) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        long end = System.nanoTime();
        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println("Around Out");
        return value;
    }
}
