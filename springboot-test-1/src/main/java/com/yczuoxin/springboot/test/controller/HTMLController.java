package com.yczuoxin.springboot.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HTMLController {

    @GetMapping(value = "/html/{message}")
    @ResponseBody
    public String get(@PathVariable String message) {
        return "<html><body>hello, " + message + "</body></html>";
    }
}
