package com.example.hello_kafka.consumer;

import com.example.hello_kafka.entities.Utente;
import com.example.hello_kafka.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    private FileService fileService;

    // @KafkaListener(topics = "hello", groupId = "academy2024")
    public void consumeMessage(String message) {
        log.info(String.format("messaggio arrivato a destinazione dal topic hello: %s", message));
    }

    @KafkaListener(topics = "hello", groupId = "academy2024")
    public void consumeJsonMessage(Utente utente) {
        log.info(String.format("messaggio arrivato a destinazione dal topic hello: %s", utente.toString()));
        fileService.writeToFile("src/main/resources/utenti.txt", utente.toString());
    }

}
