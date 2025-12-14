package com.example.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageProducer {

    final private KafkaTemplate<String, RiderLocation> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
   @RequestMapping("/send")
    public String sendMessage(@RequestParam String message){
        RiderLocation location = new RiderLocation("123", "23.45", "24.56");
        kafkaTemplate.send("my-topic-new", location);
        return "Message send : " + location.getRiderId();
    }

}
