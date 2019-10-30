package com.yczuoxin.springboot.test20.controller;

import com.yczuoxin.springboot.test20.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final Person person;

    public PersonController(Person person) {
        this.person = person;
    }

    @GetMapping("/person")
    public Person getPerson(){
        return person;
    }
}
