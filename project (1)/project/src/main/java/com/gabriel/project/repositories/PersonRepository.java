package com.gabriel.project.repositories;

import com.gabriel.project.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // The annotation is optional because the PersonRepository interface is already inheriting from JpaRepository, which is already registered as a Spring component.
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
