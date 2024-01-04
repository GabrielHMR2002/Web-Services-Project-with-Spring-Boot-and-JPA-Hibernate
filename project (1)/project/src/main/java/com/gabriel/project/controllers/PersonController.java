package com.gabriel.project.controllers;

import com.gabriel.project.entities.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {


    @GetMapping //indica que esse método responde a requisições do tipo GET http
    public ResponseEntity<Person> findAll() {

        Person person = new Person(
                UUID.randomUUID(), // ID aleatório
                "John Doe",
                "john.doe@example.com",
                "123456789",
                "password123"
        );

        return ResponseEntity.ok(person);
    }
}
