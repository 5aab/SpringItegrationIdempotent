package com.spring.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.jdbc.metadata.JdbcMetadataStore;
import org.springframework.integration.metadata.ConcurrentMetadataStore;

import javax.sql.DataSource;

@Configuration
public class MetadataStoreConfigs {

    @Bean
    public ConcurrentMetadataStore metadataStore(DataSource dataSource) {
        JdbcMetadataStore jdbcMetadataStore = new JdbcMetadataStore(dataSource);
        //jdbcMetadataStore.setTablePrefix("jdbc_rabbit_");
        return jdbcMetadataStore;
    }
}
