package com.ja0ck5;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootMultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiDatasourceApplication.class, args);
	}

//	/**
//	 * Create primary (default) DataSource.
//	 */
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource primaryDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	/**
//	 * Create second DataSource and named "secondDatasource".
//	 */
//	@Bean(name = "dataDatasource")
//	@ConfigurationProperties(prefix = "spring.data-datasource")
//	public DataSource secondDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	/**
//	 * Create primary (default) JdbcTemplate from primary DataSource.
//	 */
//	@Bean
//	@Primary
//	public JdbcTemplate primaryJdbcTemplate(DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
//
//	/**
//	 * Create second JdbcTemplate from second DataSource.
//	 */
//	@Bean(name = "dataJdbcTemplate")
//	public JdbcTemplate secondJdbcTemplate(@Qualifier("dataDatasource") DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
}
