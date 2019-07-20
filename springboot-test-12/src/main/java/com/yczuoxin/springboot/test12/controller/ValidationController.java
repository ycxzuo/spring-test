package com.yczuoxin.springboot.test12.controller;

import com.yczuoxin.springboot.test12.domain.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidationController {

    @PostMapping("/person")
    public Person save(@Valid @RequestBody Person person) {
        System.out.println(person);
        return person;
    }

}
