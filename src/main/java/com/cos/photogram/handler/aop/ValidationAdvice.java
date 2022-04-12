package com.cos.photogram.handler.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAdvice {

    @Around("execution(* com.cos.photogram.web.api.*Controller.*(..))")
    public Object apiAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // proceedingJoinPoint: In apiController, can access to all target
        // pre execute than function in apiController


        return proceedingJoinPoint.proceed(); // execute origin function
    }

    @Around("execution(* com.cos.photogram.web.*Controller.*(..))")
    public Object advice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return proceedingJoinPoint.proceed();
    }

}
