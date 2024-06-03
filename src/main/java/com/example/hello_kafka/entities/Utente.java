package com.example.hello_kafka.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Utente {

    private Long id;
    private String nome;
    private String cognome;
    private String email;

}
