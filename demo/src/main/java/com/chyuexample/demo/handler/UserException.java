package com.chyuexample.demo.handler;/*
 * @Author Chyu
 * Create on 2019/3/24 13:04
 * Email 604641446@qq.com
 * */

import com.chyuexample.demo.enums.ResultEum;

public class UserException extends RuntimeException {


    private Integer code;
    public UserException (ResultEum resultEum){
        super(resultEum.getMsg() );
        this.code=resultEum.getCode();

    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
