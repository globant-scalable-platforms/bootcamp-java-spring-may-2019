package com.bootcamp.aopactuator.aspectsactuator.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AllPackage {

    @Pointcut("execution(* com.bootcamp.aopactuator.aspectsactuator.aspect.*.*(..))")
    public void all() {  }

    @Before("all()")
    public void before(){
        System.out.println("entro ALL ");
    }

    @After("all()")
    public void after() {
        System.out.println("salio ALL ");
    }
}
