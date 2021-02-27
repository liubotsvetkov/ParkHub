package com.example.demo.controllers;

import com.example.demo.exceptions.InvalidPersonReferenceException;
import com.example.demo.models.Person;
import com.example.demo.services.PersonService;
import com.example.demo.utilities.AuthUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:8080")
    public Long createPerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person.getPersonId();
    }

    @GetMapping("/viewAll")
    @CrossOrigin(origins = "http://localhost:8080")
    public Iterable<Person> viewAllPersons() {
        return personService.getPersonHistory();
    }

    @GetMapping("/getCurrentUser")
    @CrossOrigin(origins = "http://localhost:8080")
    public String getUsername() {
        return AuthUtility.getCurrentUsername();
    }

    @GetMapping("/view/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Person viewPersonById(@PathVariable("id") int id) {
        Optional<Person> person = personService.getPerson(id);
        if(person.isPresent()) {
            return person.get();
        }

        throw new InvalidPersonReferenceException("Invalid person reference provided");
    }
}