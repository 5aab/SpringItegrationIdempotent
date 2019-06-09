package com.spring.integration.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.IdempotentReceiver;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class IntegrationServiceImpl implements IntegrationService {

    private MessagingTemplate template;
    private MessageChannel messageChannel;

    @Override
    public void sendMessage(){
        MessageHandlingException messageHandlingException=new MessageHandlingException(null,"Sample exception");
        //template.send(messageChannel, new GenericMessage(messageHandlingException));
        template.convertAndSend(messageChannel, messageHandlingException);
    }

    @ServiceActivator(inputChannel = "messageChannel")
    @IdempotentReceiver("idempotentReceiverInterceptor")
    public void receiveMessage(GenericMessage genericMessage){
        MessageHandlingException messageHandlingException= (MessageHandlingException)genericMessage.getPayload();
        log.info("working {}","Since payload is Exception, printing not to confuse");
        System.out.println("Message Printed");
    }


}
