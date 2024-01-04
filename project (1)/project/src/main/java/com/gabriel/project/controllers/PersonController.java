package com.gabriel.project.controllers;

import com.gabriel.project.entities.Person;
import com.gabriel.project.entities.RequestPerson;
import com.gabriel.project.repositories.PersonRepository;
import com.gabriel.project.services.PersonService;
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
    private PersonService personService; //component registration
    //The `PersonController` depends on `PersonService`.
    @PostMapping
    @Transactional
    public ResponseEntity<Person> registerPerson(@RequestBody @Valid RequestPerson dataPerson) {
        Person p = personService.registerPerson(dataPerson);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping //indicates that this method handles HTTP GET requests
    public ResponseEntity<List<Person>> findAll() {
        List<Person> people = personService.getAllPersons();
        if(people.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.ok(people);
        }
    }
}

