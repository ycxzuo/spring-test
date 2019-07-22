package com.yczuoxin.springboot.test12.domain;

import com.yczuoxin.springboot.test12.domain.validator.PersonNamePrefix;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
public class Person implements Serializable {

    @NotNull
    private Long id;

    @NotEmpty
    @PersonNamePrefix
    private String name;

    @Min(0)
    @Max(value = 200, message = "{yczuoxin.validation.constraints.Max.message}")
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
