package com.yczuoxin.springboot.test8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringbootTest8Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest8Application.class, args);
    }

}
