package com.gabriel.project.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Entity(name = "person")
@Table(name= "person")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String emai;
    private String phone;
    private String password;

    public Person (){

    }

    public Person(UUID id, String name, String emai, String phone, String password) {
        this.id = id;
        this.name = name;
        this.emai = emai;
        this.phone = phone;
        this.password = password;
    }
}

