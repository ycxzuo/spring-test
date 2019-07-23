package com.yczuoxin.springboot.test13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@SpringBootApplication
public class SpringbootTest13Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest13Application.class, args);
    }

}
