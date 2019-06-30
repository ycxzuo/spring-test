package com.yczuoxin.springboot.test9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class SpringbootTest9Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest9Application.class, args);
    }

}
