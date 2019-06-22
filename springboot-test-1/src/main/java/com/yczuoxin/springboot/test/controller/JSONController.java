package com.yczuoxin.springboot.test.controller;

import com.yczuoxin.springboot.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {

    @Bean
    @Qualifier("currentUser")
    public User currentUser(){
        User user = new User();
        user.setName("mike");
        user.setAge(18);
        return user;
    }

    @Autowired
    private User user;

    @GetMapping(path = "/user/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(){
        return user;
    }
}
