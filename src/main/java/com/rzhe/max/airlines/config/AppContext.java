package com.rzhe.max.airlines.config;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan(basePackages = "com.rzhe.max.airlines")
@EnableTransactionManagement
public class AppContext {
    private static Logger logger = LoggerFactory.getLogger(AppContext.class);

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.driverClassName")));
            dataSource.setUrl(environment.getProperty("jdbc.url"));
            dataSource.setUsername(environment.getProperty("jdbc.username"));
            dataSource.setPassword(environment.getProperty("jdbc.password"));
            return dataSource;
        } catch (Exception e) {
            logger.error("DataSource bean cannot be created!", e);
            return null;
        }
    }

    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        hibernateProp.put("hibernate.format_sql", environment.getProperty("hibernate.format-sql"));
        hibernateProp.put("hibernate.use_sql_comments", environment.getProperty("hibernate.use-sql-comments"));
        hibernateProp.put("hibernate.show_sql", environment.getProperty("hibernate.show-sql"));
        hibernateProp.put("hibernate.max_fetch_depth", environment.getProperty("hibernate.max-fetch-depth"));
        hibernateProp.put("hibernate.jdbc.batch_size", environment.getProperty("hibernate.jdbc.batch-size"));
        hibernateProp.put("hibernate.jdbc.fetch_size", environment.getProperty("hibernate.jdbc.fetch-size"));
        return hibernateProp;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.rzhe.max.airlines.entities");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }
}