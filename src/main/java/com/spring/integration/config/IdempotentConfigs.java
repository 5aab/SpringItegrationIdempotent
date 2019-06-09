package com.spring.integration.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.handler.advice.IdempotentReceiverInterceptor;
import org.springframework.integration.metadata.ConcurrentMetadataStore;
import org.springframework.integration.selector.MetadataStoreSelector;
import org.springframework.messaging.PollableChannel;

@Configuration
@AllArgsConstructor
public class IdempotentConfigs {

    private static final String HEADER_KEY= "restaurant";
    private ConcurrentMetadataStore metadataStore;

    @Bean
    public IdempotentReceiverInterceptor idempotentReceiverInterceptor() {
        IdempotentReceiverInterceptor idempotentReceiverInterceptor =
                new IdempotentReceiverInterceptor(new MetadataStoreSelector(m->"hashcode", m-> String.valueOf(m.getPayload().hashCode()),metadataStore));
        idempotentReceiverInterceptor.setDiscardChannelName("idempotentDiscardChannel");
        idempotentReceiverInterceptor.setThrowExceptionOnRejection(true);
        return idempotentReceiverInterceptor;
    }

    @Bean
    public PollableChannel idempotentDiscardChannel() {
        return new QueueChannel();
    }


}
