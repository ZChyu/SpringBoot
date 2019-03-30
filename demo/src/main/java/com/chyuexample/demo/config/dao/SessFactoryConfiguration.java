package com.chyuexample.demo.config.dao;/*
 * @Author Chyu
 * Create on 2019/3/20 16:17
 * Email 604641446@qq.com
 * */

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessFactoryConfiguration {

    @Value("${mybatis_config_file}")
    private String mybatisConfigureFilePath;
    @Value("${entity_package}")
    private String entityPackage;
    @Value("${mapper_path}")
    private String mapperPath;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigureFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath; //mapper扫描路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);//映射实体类
        return sqlSessionFactoryBean;
    }

}
