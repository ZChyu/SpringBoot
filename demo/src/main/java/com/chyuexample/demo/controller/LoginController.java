package com.chyuexample.demo.controller;/*
 * @Author Chyu
 * Create on 2019/4/16 8:42
 * Email 604641446@qq.com
 * */

import com.chyuexample.demo.entity.User;
import com.chyuexample.demo.service.TokenService;
import com.chyuexample.demo.service.UserService;
import com.chyuexample.demo.utils.RedisUtil;
import com.chyuexample.demo.utils.ResultUtil;
import com.chyuexample.demo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/index") //根路由
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;
    @Resource
    private RedisUtil redisUtil;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Object login(User user, HttpServletRequest request){
        TokenUtil token = new TokenUtil();
        Boolean flag= userService.loginUser(user);
        if (flag==true){
            String userAgent = request.getHeader("user-agent");
            String tokens = this.tokenService.generateToken(userAgent,user.getName());
            this.tokenService.save(tokens, user.getName());

            token.setIsLogin(1);
            token.setTokenCreateTime(System.currentTimeMillis());
            token.setTokenExpiryTime(System.currentTimeMillis()+ 60);
            token.setToken(tokens);
            //System.err.println(redisUtil.get(tokens).toString().replaceAll("\\u0000",""));
            return ResultUtil.success(token);
        }
        return  ResultUtil.error(-2,"false");

    }
}

