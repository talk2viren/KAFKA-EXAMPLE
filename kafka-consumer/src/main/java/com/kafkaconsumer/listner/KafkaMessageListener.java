package com.kafkaconsumer.listner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "javateche-demo-3",groupId = "VIREN-GROUP-ID")
//    @KafkaListener(topics = "javateche-demo-3",groupId = "viren-group-id-V2")
    public void consumer1(String message){
        log.info("consumer2 consume the message {}",message);
    }

}
