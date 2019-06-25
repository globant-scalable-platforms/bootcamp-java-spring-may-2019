/**
 * 
 */
package com.KatasInterceptors.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author brayanguerrero
 *
 */
@Aspect
@Component
public class LogRound {
	
	@Pointcut("execution(* com.KatasInterceptors.aspect.Command.execute(..))")
    public void execute() {  }


    @Around( value = "execute()")
    public String loggerInOut(ProceedingJoinPoint jp){
    	long startTime = System.nanoTime();
    	long endTime = System.nanoTime();

    	long duration = (endTime - startTime);
    	
    	String value ="";
        try {
            value =  (String) jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Error "+throwable.getMessage());
        }
    	
    	System.out.println("EL TIEMPO QUE TOMA ESTE MÉTODO ES DE "+duration+" MILISEGUNDOS");
        return value;
    }

}
