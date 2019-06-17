package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAll {

	@Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.*.*(..))")
	public void execute() {
	}

	@Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
        System.out.println("Logger All Around In");
        String value ="";
        try {  	
        	System.out.println(jp.getSignature().getDeclaringTypeName());
            value =  (String) jp.proceed();
            
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
        System.out.println("Logger All Around Out");
        return value;
    }

}
