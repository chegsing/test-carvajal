package co.com.carvajal.main;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DatasourceConfiguration
 * 
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 * 
 */
@Configuration
public class DatasourceConfiguration {

  public static final String JPA_DATASOURCE = "datasource-ebusiness";

  @Bean(name = JPA_DATASOURCE)
  @ConfigurationProperties(prefix = "spring.datasource.db-carvajal")
  public DataSource dataSourceEbusiness() {
    return DataSourceBuilder.create().build();
  }

}
