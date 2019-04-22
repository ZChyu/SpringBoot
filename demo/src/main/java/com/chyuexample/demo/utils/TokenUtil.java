package com.chyuexample.demo.utils;/*
 * @Author Chyu
 * Create on 2019/4/16 8:20
 * Email 604641446@qq.com
 * */

public class TokenUtil {
        private  String token;
        //token 创建时间
        private Long tokenCreateTime;
        //失效时间
        private Long tokenExpiryTime;
        private Integer isLogin;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(Long tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    public Long getTokenExpiryTime() {
        return tokenExpiryTime;
    }

    public void setTokenExpiryTime(Long tokenExpiryTime) {
        this.tokenExpiryTime = tokenExpiryTime;
    }

    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }
}
