package config;

import com.rzhe.max.airlines.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Import(AppConfig.class)
@Configuration
@ComponentScan(basePackages = "com.rzhe.max.airlines")
@EnableTransactionManagement
public class TestAppConfig {
    private static Logger logger = LoggerFactory.getLogger(TestAppConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:testDB/schema.sql", "classpath:testDB/test-data.sql").build();
        } catch (Exception e) {
            logger.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }

//    private Properties hibernateProperties() {
//        Properties hibernateProp = new Properties();
//        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        hibernateProp.put("hibernate.format_sql", true);
//        hibernateProp.put("hibernate.use_sql_comments", true);
//        hibernateProp.put("hibernate.show_sql", true);
//        hibernateProp.put("hibernate.max_fetch_depth", 3);
//        hibernateProp.put("hibernate.jdbc.batch_size", 10);
//        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
//        return hibernateProp;
//    }
}
