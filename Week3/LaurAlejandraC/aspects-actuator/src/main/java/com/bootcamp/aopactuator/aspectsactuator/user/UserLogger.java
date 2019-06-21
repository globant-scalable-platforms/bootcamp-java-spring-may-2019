package com.bootcamp.aopactuator.aspectsactuator.user;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserLogger {

    @Pointcut("execution(public void com.bootcamp.aopactuator.aspectsactuator.user.UserController.deleteUser(..))")
    public void deleteUser(){}

    @Around("deleteUser()")
    public void userDeletionLog(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Beginning user deletion");
        long startTime = System.nanoTime();

        try {
            proceedingJoinPoint.proceed();
        }
        catch (Throwable throwable){
            System.out.println("Error: " + throwable);
        }

        double elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        System.out.println("User deletion completed in: " + elapsedTime + "ms");
    }
}
