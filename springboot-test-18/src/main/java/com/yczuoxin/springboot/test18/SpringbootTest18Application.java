package com.yczuoxin.springboot.test18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        application.run(args);
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.err.println("当前激活的 profile ： " + Arrays.toString(environment.getActiveProfiles()));

        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment) environment;
            MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
            Map<String, Object> resource = new HashMap<>(2);
            resource.put("server.port", 1111);
            resource.put("spring.profiles.active", "aaa");
            PropertySource propertySource = new MapPropertySource("java-code", resource);
            propertySources.addFirst(propertySource);
        }
    }
}
