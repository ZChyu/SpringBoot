package com.chyuexample.demo.service;/*
 * @Author Chyu
 * Create on 2019/4/16 9:57
 * Email 604641446@qq.com
 * */





import com.alibaba.fastjson.JSONObject;
import com.chyuexample.demo.entity.User;
import com.chyuexample.demo.utils.RedisUtil;
import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service("tokenService")
public class TokenService {

    @Resource
    private RedisUtil redisUtil;

    //生成token(格式为token:设备-加密的用户名-时间-六位随机数)
    public String generateToken(String userAgentStr, String username) {
        StringBuilder token = new StringBuilder("token:");
        //设备
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        if (userAgent.getOperatingSystem().isMobileDevice()) {
            token.append("MOBILE-");
        } else {
            token.append("PC-");
        }
        //加密的用户名
        token.append(DigestUtils.md5Hex(username) + "-");
        //时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "-");
        //六位随机字符串
        //token.append(new Random().nextInt(999999 - 111111 + 1) + 111111 );
        token.append(UUID.randomUUID().toString().replaceAll("-",""));
        System.out.println("token-->" + token.toString());
        return token.toString();
    }

    //把token存到redis中
    public void save(String token, String  username) {
        if (token.startsWith("token:PC")) {
            redisUtil.setex(token,username,60*60*3);
        } else {
            redisUtil.set(token,username);
        }
    }

}


