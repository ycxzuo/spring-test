package com.yczuoxin.springboot.test.controller;

import com.yczuoxin.springboot.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XMLController {

    @Autowired
    private User user;

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_XML_VALUE)
    public User get(){
        return user;
    }
}
