package com.yczuoxin.springboot.test18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySourcesPropertyResolver;

import java.util.Arrays;

@SpringBootApplication
@ImportResource(locations = {
        "META-INF/spring/context-test.xml",
        "META-INF/spring/context-demo.xml",
        "META-INF/spring/context-prod.xml"
})
public class SpringbootTest18Application implements EnvironmentAware {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringbootTest18Application.class);
        application.setAdditionalProfiles("prod");
        application.run();
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.err.println("当前激活的 profile ： " + Arrays.toString(environment.getActiveProfiles()));
    }
}
