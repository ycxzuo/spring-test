package com.yczuoxin.springboot.test16;

public class User {
    private String name;

    private int age;

    private String description;

    public User(String name, int age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
