package com.bootcamp.aopactuator.aspectsactuator.aspect.Batch;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerRound {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Batch.Command.execute(..))")
    public void execute() {  }

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Greeting.GreetingInterface.Greeting(..))")
    public void greetingExecution(){}


    @Around( value = "greetingExecution()")
    public String loggerGreetingInOut(ProceedingJoinPoint jp){
        System.out.println("Around Logger Greeting Round  In");
        String value ="";
        try {
            value =  (String) jp.proceed();

        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("Around  Logger Gretting Round Out");
        return value;
    }


    @Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
        System.out.println("Around In");
        String value ="";
        try {
            value =  (String) jp.proceed();

        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("Around Out");
        return value;
    }
}
