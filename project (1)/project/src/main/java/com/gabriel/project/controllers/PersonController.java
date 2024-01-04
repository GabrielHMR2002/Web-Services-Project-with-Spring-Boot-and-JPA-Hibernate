package com.gabriel.project.controllers;

import com.gabriel.project.entities.Person;
import com.gabriel.project.entities.RequestPerson;
import com.gabriel.project.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Person> registerPerson(@RequestBody @Valid RequestPerson dataPerson) {
        System.out.println(dataPerson);
        var person = new Person();
        BeanUtils.copyProperties(dataPerson, person);
        System.out.println(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(person));
    }
    
    @GetMapping //indica que esse método responde a requisições do tipo GET http
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }
}
