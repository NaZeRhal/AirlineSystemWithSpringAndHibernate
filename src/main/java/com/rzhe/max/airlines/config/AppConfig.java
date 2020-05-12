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
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.rzhe.max.airlines")
@EnableTransactionManagement
public class AppConfig {
    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driverClassName")));
            dataSource.setUrl(env.getProperty("spring.datasource.url"));
            dataSource.setUsername(env.getProperty("spring.datasource.username"));
            dataSource.setPassword(env.getProperty("spring.datasource.password"));
            return dataSource;
        } catch (Exception e) {
            logger.error("DataSource bean cannot be created!", e);
            return null;
        }
//        try {
//            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
//            return dbBuilder.setType(EmbeddedDatabaseType.H2)
//                    .addScripts("classpath:testDB/schema.testDB", "classpath:testDB/com.rzhe.max.airlines.test-data.testDB").build();
//        } catch (Exception e) {
//            logger.error("Embedded DataSource bean cannot be created!", e);
//            return null;
//        }
    }

    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", env.getProperty("spring.hibernate.dialect"));
        hibernateProp.put("hibernate.format_sql", env.getProperty("spring.hibernate.format-sql"));
        hibernateProp.put("hibernate.use_sql_comments", env.getProperty("spring.hibernate.use-sql-comments"));
        hibernateProp.put("hibernate.show_sql", env.getProperty("spring.hibernate.show-sql"));
        hibernateProp.put("hibernate.max_fetch_depth", env.getProperty("spring.hibernate.max-fetch-depth"));
        hibernateProp.put("hibernate.jdbc.batch_size", env.getProperty("spring.hibernate.jdbc.batch-size"));
        hibernateProp.put("hibernate.jdbc.fetch_size", env.getProperty("spring.hibernate.jdbc.fetch-size"));
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