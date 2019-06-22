package com.yczuoxin.springboot.test5.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/message")
    public String echo(){
        return "hello, world";
    }
}
