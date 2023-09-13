package com.example.dataGenerator.api.controller;

import com.example.dataGenerator.api.model.Person;
import com.example.dataGenerator.consts.Sex;
import com.example.dataGenerator.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/person")
    public Person getPerson(@RequestParam Sex sex, @RequestParam(required = false) Integer size){
        Optional person = personService.getPerson(sex);
        if(person.isPresent()){
            return (Person) person.get();
        }
        return null;
    }
    @GetMapping("/persons")
    public List<Person> getPersons(@RequestParam(defaultValue = "RANDOM") Sex sex, @RequestParam(required = false) Integer size){
        int count = size != null ? size : 1;
        List<Person> person = new ArrayList<>();
        for (int i = 0; i < count; i++){
            person.add(personService.getPerson(sex).get());
        }
        return person;
    }

}
