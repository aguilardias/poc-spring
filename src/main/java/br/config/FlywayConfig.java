package br.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

	@Autowired
	DataSource dataSource;

	@Bean(initMethod = "migrate")
	public Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setLocations("classpath:db/migration");
		flyway.setDataSource(dataSource);
		return flyway;
	}

}
