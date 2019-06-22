package com.yczuoxin.springboot.test8.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Access(value = AccessType.FIELD)
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
