package com.lucaffo.dinotodo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/// Entity sta per JPA Entity
/// Di default se non viene definito è una table con il nome della classe
/// A noi interessa tenerla come una classe singolare ma la tabella si chiamerà
/// "users" al plurale.
@Entity
@Table(name = "users")
public class User {

    /// Id generato. Esiste anche SEQUENCE.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    public long id;

    /// Colonna per il nome, con get e set generati da Lombok
    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    // Colonna per l'email, con get e set generati da Lombok
    @Setter
    @Getter
    @Column(name = "email")
    private String email;
}