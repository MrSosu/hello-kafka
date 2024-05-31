package com.example.hello_kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "hello", groupId = "academy2024")
    public void consumeMessage(String message) {
        log.info(String.format("messaggio arrivato a destinazione dal topic hello: %s", message));
    }

}
