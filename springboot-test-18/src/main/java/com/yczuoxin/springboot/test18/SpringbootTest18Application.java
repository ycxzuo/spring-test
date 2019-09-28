package com.yczuoxin.springboot.test18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {
        "META-INF/spring/context-test.xml",
        "META-INF/spring/context-demo.xml",
        "META-INF/spring/context-prod.xml"
})
public class SpringbootTest18Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest18Application.class, args);
    }

}
