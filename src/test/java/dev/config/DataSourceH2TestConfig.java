/**
 * 
 */
package dev.config;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author boukh
 *
 */
@Configuration
public class DataSourceH2TestConfig {
	
  @Bean
  public DataSource dataSource() {
  return (DataSource) new EmbeddedDatabaseBuilder()
  .setType(EmbeddedDatabaseType.H2)
  .addScript("classpath:schema-h2.sql")
  .addScript("classpath:data-h2.sql")
  .build();
  }
}