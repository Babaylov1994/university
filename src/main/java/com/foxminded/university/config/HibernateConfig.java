package com.foxminded.university.config;

import com.foxminded.university.exception.ConfigException;
import com.foxminded.university.service.department.DepartmentService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan("com.foxminded.university")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    @Value("${url}")
    private String url;
    @Value("${driver}")
    private String driver;
    @Value("${dbUserName}")
    private String userName;
    @Value("${password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${entitymanager.packages.to.scan}")
    private String entityManagerPackagesToScan;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

    @Bean
    public DataSource dataSource() {
        logger.trace("Entered method dataSource");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            logger.debug("try get connection");
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(userName);
            dataSource.setPassword(password);
        }catch (PropertyVetoException exception) {
            logger.error("cannot create connection");
            throw new ConfigException("cannot create connection", exception);
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(entityManagerPackagesToScan);
        sessionFactoryBean.setHibernateProperties(hibProperties());
        return sessionFactoryBean;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect);
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
