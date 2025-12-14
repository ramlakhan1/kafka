package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
    public void listenMessage(String message){
        System.out.println("Listening message : " +  message);
    }

    @KafkaListener(topics = "my-topic", groupId = "my-new-group-new")
    public void listenMessage1(String message){
        System.out.println("Listening message 1: " +  message);
    }
}
