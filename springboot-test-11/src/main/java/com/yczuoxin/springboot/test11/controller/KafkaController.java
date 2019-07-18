package com.yczuoxin.springboot.test11.controller;

import com.yczuoxin.springboot.test11.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/message/send")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("springboot-test",0, "message", message);
        return message;
    }

    @PostMapping("/user/send")
    public User sendObject(@RequestBody User user){
        kafkaTemplate.send("springboot-object",0,"object", user);
        return user;
    }
}
