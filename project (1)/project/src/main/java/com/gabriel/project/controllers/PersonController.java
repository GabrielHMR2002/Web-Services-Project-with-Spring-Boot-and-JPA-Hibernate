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

import java.util.*;

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


    /*

    *    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");

        }

        return ResponseEntity.status(HttpStatus.OK).body(product0.get());

    }/
     */

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePerson(@PathVariable(value = "id") UUID id) {
        Optional<Person> optionalPerson = personService.findById(id);

        if (optionalPerson.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Id not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            Person person = optionalPerson.get();
            return ResponseEntity.status(HttpStatus.OK).body(person);
        }
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

