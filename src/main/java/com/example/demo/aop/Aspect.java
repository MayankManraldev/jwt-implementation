package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
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
}
