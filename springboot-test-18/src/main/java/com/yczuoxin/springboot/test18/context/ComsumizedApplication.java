package com.yczuoxin.springboot.test18.context;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

public class ComsumizedApplication implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> resource = new HashMap<>(2);
        resource.put("server.port", 2222);
        resource.put("spring.profiles.include", "aaa");
        PropertySource propertySource = new MapPropertySource("spring-listener", resource);
        propertySources.addFirst(propertySource);
    }
}
