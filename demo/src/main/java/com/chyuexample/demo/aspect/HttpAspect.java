package com.chyuexample.demo.aspect;/*
 * @Author Chyu
 * Create on 2019/3/23 21:39
 * Email 604641446@qq.com
 * */
import com.chyuexample.demo.utils.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class HttpAspect {
    @Resource
    private RedisUtil redisUtil;
    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.chyuexample.demo.controller.*.*(..))")
    private  void log(){

    }

    @Around("log()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
       // System.err.println("method" + method);
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        //System.err.println(className + "." + methodName + "()");

    }
    @Before("log()")
    public void  doBefore(JoinPoint joinPoint) throws  Exception{
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String headerToken= request.getHeader("headers");
        //System.err.println("httpAopToken" + headerToken);

        logger.info("header={}",request.getHeader("headers"));
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
