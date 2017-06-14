package com.ja0ck5.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Jack on 2017/6/13.
 */
@Configuration
public class DataSourceConfiguration {
    /**
     * Create primary (default) DataSource.
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Create second DataSource and named "dataDatasource".
     */
    @Bean(name = "dataDatasource")
    @ConfigurationProperties(prefix = "spring.data-datasource")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Create primary (default) JdbcTemplate from primary DataSource.
     */
    @Bean
    @Primary
    public JdbcTemplate primaryJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * Create second JdbcTemplate from second DataSource.
     */
    @Bean(name = "dataJdbcTemplate")
    public JdbcTemplate secondJdbcTemplate(@Qualifier("dataDatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
