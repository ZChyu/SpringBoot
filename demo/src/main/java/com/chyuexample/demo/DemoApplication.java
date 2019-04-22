package com.chyuexample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication   //注入springboot 启动springBoot
public class DemoApplication  extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return  builder.sources(this.getClass());
    }

}
