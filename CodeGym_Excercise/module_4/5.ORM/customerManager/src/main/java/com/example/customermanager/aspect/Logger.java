package com.example.customermanager.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.example.customermanager.service.CustomerServiceImpl.*(..))")
    public void log(){
        error();
    }

    public void error(){
        System.out.println("[CMS] ERROR!");
    }
}
