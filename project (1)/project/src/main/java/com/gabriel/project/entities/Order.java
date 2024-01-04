package com.gabriel.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity(name = "Order")
@Table(name = "Order")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    private UUID id;
    private Instant moment;
    private Person client;

    public Order() {

    }

    public Order(UUID id, Instant moment, Person client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }
}
