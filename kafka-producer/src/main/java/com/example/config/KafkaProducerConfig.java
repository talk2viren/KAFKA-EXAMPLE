package com.example.config;

import org.apache.kafka.clients.admin.NewTopic;

public class KafkaProducerConfig {

    public NewTopic createTopic(){
        return new NewTopic("javateche-demo-3",5,(short)1);
    }
}
