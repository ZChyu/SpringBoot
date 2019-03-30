package com.chyuexample.demo.config.service;/*
 * @Author Chyu
 * Create on 2019/3/21 9:22
 * Email 604641446@qq.com
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration //告诉spring 这是spring的配置
@EnableTransactionManagement //开启事务的管理
public class TransactionManagementConfiguration  implements TransactionManagementConfigurer{
    @Autowired//注入dataSource
    private DataSource dataSource;
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
