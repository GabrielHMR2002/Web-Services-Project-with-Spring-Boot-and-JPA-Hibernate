package com.gabriel.project.services;

import com.gabriel.project.entities.Person;
import com.gabriel.project.entities.RequestPerson;
import com.gabriel.project.repositories.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository; //component registration

    public Person registerPerson(RequestPerson dataPerson){
        var person = new Person();
        BeanUtils.copyProperties(dataPerson, person);
        return repository.save(person);
    }
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    public Optional<Person> findById(UUID id) {
        return repository.findById(id);
    }

    /*
    *  public  Person findById(UUID id){

        Optional<Person> obj = repository.findById((id));
        return obj.get();

    }
    * */

}
