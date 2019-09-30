package com.yczuoxin.springboot.test18.controller;

import com.yczuoxin.springboot.test18.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationController {

    @Autowired
    private Person person;

    @GetMapping("/anno/person")
    public Person person(){
        return person;
    }

}
