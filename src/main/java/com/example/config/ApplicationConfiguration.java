package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Value("${spring.local.datasource.url}")
    private String mysqlURL;

    @Value(("${spring.local.datasource.username}"))
    private String usernameURL;

    @Value("${spring.local.datasource.password}")
    private  String passwordURL;

    @Value("${spring.local.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource getDataSource(){

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(mysqlURL);
        dataSourceBuilder.username(usernameURL);
        dataSourceBuilder.password(passwordURL);

        return dataSourceBuilder.build();
    }

}
