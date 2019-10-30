package com.yczuoxin.springboot.test20.controller;

import com.yczuoxin.springboot.test20.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Person2Controller {

    private final Person person2;

    public Person2Controller(Person person2) {
        this.person2 = person2;
    }

    @GetMapping("/person2")
    public Person getPerson2(){
        return person2;
    }
}
