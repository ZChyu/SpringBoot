package com.chyuexample.demo.handler;/*
 * @Author Chyu
 * Create on 2019/3/21 10:34
 * Email 604641446@qq.com
 * */

import com.chyuexample.demo.aspect.HttpAspect;
import com.chyuexample.demo.entity.Result;
import com.chyuexample.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //注入controller controller可以调用异常类
public class GlobalExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*  @ExceptionHandler(value = Exception.class)
      @ResponseBody
      private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
           Map<String,Object> modelMap = new HashMap<String, Object>();
           modelMap.put("success",false);
           modelMap.put("errMsg",e.getMessage());
           return modelMap;
      }
      */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        } else {
            return ResultUtil.error(-1, e.getMessage());
        }

    }
}


