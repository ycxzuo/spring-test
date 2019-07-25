package com.yczuoxin.springboot.test12.controller;

import com.yczuoxin.springboot.test12.domain.Person;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    @PostMapping("/person")
    public Person save(@Validated @RequestBody Person person) {
        System.out.println(person);
        return person;
    }
}
