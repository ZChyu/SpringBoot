package com.chyuexample.demo.utils;/*
 * @Author Chyu
 * Create on 2019/3/24 19:38
 * Email 604641446@qq.com
 * */

import com.chyuexample.demo.entity.Result;

public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
