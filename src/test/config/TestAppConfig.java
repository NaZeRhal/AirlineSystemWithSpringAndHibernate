package config;

import com.rzhe.max.airlines.config.AppDataConfig;
import com.rzhe.max.airlines.config.WebConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Import({AppContext.class, WebConfig.class})
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
}
