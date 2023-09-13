package com.example.dataGenerator.service;

import com.example.dataGenerator.api.model.Person;
import com.example.dataGenerator.consts.Sex;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PersonService {
    public Optional<Person> getPerson(Sex sex) {
        Person person = new Person(sex);
        return Optional.of(person);
    }
}
