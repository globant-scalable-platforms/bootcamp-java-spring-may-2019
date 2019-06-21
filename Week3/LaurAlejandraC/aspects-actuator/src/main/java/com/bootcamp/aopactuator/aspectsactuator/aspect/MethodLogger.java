package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLogger {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect..*(..))")
    public void executionInPackage(){ }

    @Around("executionInPackage()")
    public String methodLogger(ProceedingJoinPoint proceedingJoinPoint){
        String methodExecuting = "";
        String result = "";

        try{
            result = (String) proceedingJoinPoint.proceed();
            methodExecuting = proceedingJoinPoint.getSignature().getName();
        }
        catch (Throwable throwable){
            System.out.println("Error: " + throwable.getMessage());
        }

        System.out.println("Executed method: " + methodExecuting);

        return result;
    }
}
