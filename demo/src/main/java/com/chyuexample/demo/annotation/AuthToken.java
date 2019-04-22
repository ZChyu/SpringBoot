package com.chyuexample.demo.annotation;/*
 * @Author Chyu
 * Create on 2019/4/18 10:50
 * Email 604641446@qq.com
 * */

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {
    String value() default "";
}
