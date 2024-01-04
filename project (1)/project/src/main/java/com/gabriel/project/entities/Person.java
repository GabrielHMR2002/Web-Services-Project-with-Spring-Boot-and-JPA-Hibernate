package com.gabriel.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity(name = "person")
@Table(name = "person")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;
    @JsonIgnore //SUPER HIPER MEGA IMPORTANTE ESSA NOTAÇÃO
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Person() {

    }

    public Person(UUID id, String name, String emai, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = emai;
        this.phone = phone;
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

}

