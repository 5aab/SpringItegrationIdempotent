package com.spring.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfigs {

    @Bean
    public MessageChannel messageChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessagingTemplate messagingTemplate(){
        return new MessagingTemplate();
    }
}
