package com.yczuoxin.springboot.test17.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(
        objectName = "com.yczuoxin.springboot.test17.jmx:type=SimpleBean",
        description = "一个简单的 Bean，被 Spring 托管"
)
@Component
public class SimpleBean {

    private Long id;

    private String name;

    private Integer age;

    @ManagedAttribute(description = "ID 属性")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManagedAttribute(description = "Name 属性")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManagedAttribute(description = "Age 属性")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManagedOperation(description = "display 操作")
    public String display() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
