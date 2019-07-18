package com.yczuoxin.springboot.test11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringbootTest11Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest11Application.class, args);
    }

}
