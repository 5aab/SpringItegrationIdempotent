package com.spring.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableIntegration
@EnableTransactionManagement
public class IntegrationTestApplication {

    public static void main(String[] args){
        SpringApplication.run(IntegrationTestApplication.class, args);
    }
}
