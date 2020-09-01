package com.talbn1.insurancelistener.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author talbn on 8/27/2020
 **/
@Service

public class RabbitConsumerService {

    private final SendToDBService sendToDBService;

    public RabbitConsumerService(SendToDBService sendToDBService) {
        this.sendToDBService = sendToDBService;
    }

    @RabbitListener(queues = "Queue-1")
    public void transfersMessage(String report) throws JsonProcessingException {
        sendToDBService.excutePost(report);
    }
}
