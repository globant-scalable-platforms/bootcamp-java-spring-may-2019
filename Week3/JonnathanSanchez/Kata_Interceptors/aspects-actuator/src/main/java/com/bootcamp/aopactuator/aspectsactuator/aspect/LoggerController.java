package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerController {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.Command.printer())")
    public void execute() {  }

    @Around( value = "execute()")
    public void loggerVoidMethod(ProceedingJoinPoint jp){
        System.out.println("Around In void method");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("Around Out void method");
    }
}