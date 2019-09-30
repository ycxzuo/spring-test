package com.yczuoxin.springboot.test18.config;

import com.yczuoxin.springboot.test18.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PersonConfiguration {

    @Bean
    @Profile(value = "test")
    public Person zuoxin(){
        Person person = new Person();
        person.setName("zuoxin");
        return person;
    }

    @Bean
    @Profile(value = "demo")
    public Person xl(){
        Person person = new Person();
        person.setName("xl");
        return person;
    }

    @Bean
    @Profile(value = "prod")
    public Person hxb(){
        Person person = new Person();
        person.setName("hxb");
        return person;
    }

}
