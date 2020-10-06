package com.example.conference.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PesistenceConfiguration {
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/conference");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("Parimala202!");
        System.out.println("My custom datasource has been initialized and set");
        return dataSourceBuilder.build();
    }
}
