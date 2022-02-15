package com.foxminded.university.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan("com.foxminded.university")
@PropertySource("classpath:database.properties")
public class SpringJdbcConfig {

    @Value("${url}")
    private String url;
    @Value("${driver}")
    private String driver;
    @Value("${dbUserName}")
    private String userName;
    @Value("${password}")
    private String password;

    @Bean
    DataSource dataSource() throws IOException {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) throws IOException {
        return new JdbcTemplate(dataSource());
    }

}
