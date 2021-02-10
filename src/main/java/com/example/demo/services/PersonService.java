package com.example.demo.services;

import com.example.demo.models.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public Iterable<Person> getPersonHistory() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(int id) {
        return personRepository.findById(id);
    }
}