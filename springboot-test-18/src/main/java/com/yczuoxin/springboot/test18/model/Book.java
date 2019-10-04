package com.yczuoxin.springboot.test18.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "book")
public class Book {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
