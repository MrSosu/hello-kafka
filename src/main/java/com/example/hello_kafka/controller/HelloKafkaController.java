package com.example.hello_kafka.controller;

import com.example.hello_kafka.entities.Utente;
import com.example.hello_kafka.producer.KafkaJsonProducer;
import com.example.hello_kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class HelloKafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Messaggio inviato in coda correttamente nel topic hello", HttpStatus.OK);
    }

    @PostMapping("/send-json")
    public ResponseEntity<String> sendMessage(@RequestBody Utente utente) {
        kafkaJsonProducer.sendMessage(utente);
        return new ResponseEntity<>("Messaggio inviato in coda correttamente nel topic hello in formato JSON", HttpStatus.OK);    }

}
