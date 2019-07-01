package com.bootcamp.aopactuator.aspectsactuator.aspect2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger3 {
	
	@Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect2.Command3.execute(..))")
    public void execute() {  }
	
	@Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
        System.out.println("new Aspect In - different package ");
        String value ="";
        try {  	
            value =  (String) jp.proceed();
            
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("new Aspect Out - different package");
        return value;
    }


}
