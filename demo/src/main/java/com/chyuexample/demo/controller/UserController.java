package com.chyuexample.demo.controller;/*
 * @Author Chyu
 * Create on 2019/3/21 9:57
 * Email 604641446@qq.com
 * */

import com.chyuexample.demo.entity.Result;
import com.chyuexample.demo.entity.User;
import com.chyuexample.demo.service.UserService;
import com.chyuexample.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin") //根路由
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listuser",method = RequestMethod.POST)
    public Object ListUser( ){

        return ResultUtil.success(userService.getUserList());

    }
    @RequestMapping(value = "/getuserbyid",method = RequestMethod.POST)
    public Result<User> getUserId( @Valid @ModelAttribute("Id") Integer Id,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        if(userService.getUserById(Id)==null){
            return ResultUtil.error(2,null);
        }
        return ResultUtil.success(userService.getUserById(Id));

    }
    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    @ResponseBody
    public Object addUser(User user){ //@RequestBody 接收xml啥
        System.err.println(user.toString());
        return ResultUtil.success(userService.addUser(user));

    }
    @RequestMapping(value = "/modifyuser",method = RequestMethod.GET)
    @ResponseBody
    public Object modifyUser( User user){ //@RequestBody 接收xml啥
        System.err.println(user.toString());
        return ResultUtil.success(userService.modifyUser(user));

    }
    @RequestMapping(value = "/deleteyuser",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteyUser(Integer Id){ //@RequestBody 接收xml啥
        return ResultUtil.success(userService.deleteUser(Id));

    }
    @RequestMapping(value = "/loginuser",method = RequestMethod.POST)
    @ResponseBody //加上 @ResponseBody 后，会直接返回 json 数据。
                    // @RequestBody 将 HTTP 请求正文插入方法中，使用适合的 HttpMessageConverter 将请求体写入某个对象。
                    //是作用在形参列表上，用于将前台发送过来固定格式的数据【xml 格式或者 json等】封装为对应的 JavaBean 对象，封装时使用到的一个对象是系统默认配置的 HttpMessageConverter进行解析，然后封装到形参上。
    public  Map<String,Object> loginuser( User user){ //@RequestBody 接收xml啥
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.loginUser(user));
        return modelMap;

    }
    @RequestMapping(value = "/test")
    public String test(){
        return "login";
    }


}
