package com.example.controller;

import com.example.service.KafkaMessagePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private KafkaMessagePublisher messagePublisher;

    public EventController(KafkaMessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @GetMapping("/publish/{message}")
    public ResponseEntity<?>  publishMessage(@PathVariable String message){
        for (int i = 0; i <= 100000; i++) {
            messagePublisher.sendMessageToTopic(message+" : "+i);
        }
        return ResponseEntity.ok("message publish successfully ..");
    }
}
