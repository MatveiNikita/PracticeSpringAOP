package com.learnAOP.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


public class Pointcuts {
    @Pointcut("execution(* com.learnAOP.demo.service.BookService.get(..))")
    public void allGetMethod(){
    }

    @Pointcut("execution(* com.learnAOP.demo.service.BookService.add(..))")
    public void allAddMethod(){
    }
}
