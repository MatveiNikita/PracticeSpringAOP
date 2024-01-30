package com.learnAOP.demo.aop;

import com.learnAOP.demo.entity.Book;
import com.learnAOP.demo.util.CustomResponse;
import com.learnAOP.demo.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspects {

    @Around("Pointcuts.allGetMethod()")
    public Object aroundGetingAdvice(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String title = null;

        if (methodSignature.getName().equals("getAll")){
            log.info("Try to get all books");
        } else if (methodSignature.getName().equals("getBookByTitle")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof Book) {
                    title = (String) arg;
                    log.info("Try to get by title {}", title);
                }
            }
        }
            Object result = null;
            try {
                result = joinPoint.proceed();
            } catch (Throwable e) {
                log.error(e.getMessage(), e);
                result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
            }

            if (methodSignature.getName().equals("getAll")){
                log.info("We got books");
            } else if (methodSignature.getName().equals("getBookByTitle")) {
                log.info("We got a book by title {}", title);
            }
        return result;
    }


    @Around("Pointcuts.allAddMethod()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Book book = null;
        if(methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for (Object args:
                 arguments) {
                if (args instanceof Book){
                    book = (Book) args;
                    log.info("Try to add book {} in our library", book.getTitle());
                }
            }
        }
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(),e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        log.info("Book - {} was added", book.getTitle());
        return result;
    }
}
