package com.chyuexample.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/index")
public class TestController {
    @RequestMapping(value = "login")
    public String login(){
        System.err.print("登录页面加载成功！");
        return "login";
    }
    @RequestMapping(value = "getUserById")
    public String getUserById(){
        return "getUserInfoById";
    }
}
