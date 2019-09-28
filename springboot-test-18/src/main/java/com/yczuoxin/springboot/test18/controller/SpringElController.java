package com.yczuoxin.springboot.test18.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class SpringElController {

    @Value("${person.id}")
    private Long id;

    @Value("${person.name:yczuoxin}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    @GetMapping("/el/person")
    public Map<String, Object> getMap() {
        Map<String, Object> result = new LinkedHashMap<>(3);
        result.putIfAbsent("id", id);
        result.putIfAbsent("name", name);
        result.putIfAbsent("age", age);
        return result;
    }

}
