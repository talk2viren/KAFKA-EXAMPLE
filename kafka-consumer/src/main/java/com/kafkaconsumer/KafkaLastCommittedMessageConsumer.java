package com.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class KafkaLastCommittedMessageConsumer {

//    @KafkaListener(topics = "javateche-demo-3",groupId = "VIREN-GROUP-ID")

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "VIREN-GROUP-ID");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Assign the consumer to a specific partition
        TopicPartition partition = new TopicPartition("javateche-demo-3", 0); // Replace 0 with the desired partition number
        consumer.assign(Collections.singleton(partition));

//        consumer.seek(partition,10001);

//        consumer.seekToBeginning(List.of(partition));

        // Seek to the end of the partition
//        consumer.seekToBeginning(Collections.singleton(partition));
//        consumer.seekToEnd(Collections.singleton(partition));

        // Get the last committed offset
//        long lastCommittedOffset = consumer.position(partition);
//        System.out.println("Last committed partition : "+lastCommittedOffset);

        // Poll for records and process messages from the next offset
//        consumer.seek(partition, lastCommittedOffset); // Start consuming from the last committed offset

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                String key = record.key();
                String value = record.value();
                long offset = record.offset();
                System.out.println("Received message: Key = " + key + ", Value = " + value + ", Offset = " + offset);
            }
        }

    }
}
