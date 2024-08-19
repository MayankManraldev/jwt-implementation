package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    Logger logger=LoggerFactory.getLogger(Aspect.class);
        @Before(value = "within(com.example.demo.controllers..*)")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Executing---->" + joinPoint.getSignature());
    }

    @Pointcut("execution(public * com.example.demo.service.*.*(..))")
    private void publicMethods() {
    }
    @Around(value = "publicMethods()")
    public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("The method aroundAdvice() before invocation of the method " + jp.getSignature().getName() + " method");
        jp.proceed();
        System.out.println(
                "The method aroundAdvice() after invocation of the method "
                        + jp.getSignature().getName() + " method");
    }

}
