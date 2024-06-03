package com.example.hello_kafka.producer;

import com.example.hello_kafka.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    @Autowired
    private KafkaTemplate<String, Utente> kafkaTemplate;

    public void sendMessage(Utente utente) {
        Message<Utente> message = MessageBuilder
                .withPayload(utente)
                .setHeader(KafkaHeaders.TOPIC, "hello")
                .build();
        kafkaTemplate.send(message);
    }

}
