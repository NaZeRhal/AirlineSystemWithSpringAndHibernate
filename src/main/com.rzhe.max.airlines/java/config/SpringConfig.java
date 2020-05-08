package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:app-config.xml")

@Configuration
//@ComponentScan(basePackages = "entities")
public class SpringConfig {
}
