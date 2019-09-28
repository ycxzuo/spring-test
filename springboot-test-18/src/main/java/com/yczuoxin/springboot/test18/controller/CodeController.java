package com.yczuoxin.springboot.test18.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CodeController implements EnvironmentAware {

    private Long id;

    private String name;

    private Integer age;

    @GetMapping("/code/person")
    public Map<String, Object> getMap() {
        Map<String, Object> result = new LinkedHashMap<>(3);
        result.putIfAbsent("id", id);
        result.putIfAbsent("name", name);
        result.putIfAbsent("age", age);
        return result;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.id = environment.getProperty("person.id", Long.class);
        this.name = environment.getProperty("person.name", String.class);
        this.age = environment.getProperty("person.age", Integer.class);
    }
}
