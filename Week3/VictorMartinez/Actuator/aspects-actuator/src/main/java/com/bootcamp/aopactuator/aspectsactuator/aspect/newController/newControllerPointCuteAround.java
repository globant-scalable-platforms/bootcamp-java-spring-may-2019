package com.bootcamp.aopactuator.aspectsactuator.aspect.newController;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;


@Component
@Aspect
public class newControllerPointCuteAround {

    //@Pointcut("")


    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.newController.newControllerImpl.newGreeting(..))")
    public void execute() {  }

    @Around( value = "execute()")
    public String loggerGreetingInOut(ProceedingJoinPoint jp){
        System.out.println("newController Around Logger Execution Round  In");
        String value ="";
        try {
            value =  (String) jp.proceed();

        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("newController Around  Logger Execution Round Out");
        return value;
    }

}
