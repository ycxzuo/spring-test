package com.yczuoxin.springboot.test10.controller;

import com.yczuoxin.springboot.test10.entity.Person;
import com.yczuoxin.springboot.test10.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/get/{id}")
    public Person findById(@PathVariable String id){
        return personRepository.findById(id);
    }

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }
}
