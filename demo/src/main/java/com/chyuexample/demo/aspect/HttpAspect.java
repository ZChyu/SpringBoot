package com.chyuexample.demo.aspect;/*
 * @Author Chyu
 * Create on 2019/3/23 21:39
 * Email 604641446@qq.com
 * */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.chyuexample.demo.controller.UserController.*(..))")
    private  void log(){

    }
    @Before("log()")
    public void  doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method=",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //args
        logger.info("args",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("*******doafter******");
    }
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfter(Object object){
        logger.info("response={}",object.toString());

    }
}
