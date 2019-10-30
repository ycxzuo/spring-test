package com.yczuoxin.springboot.test20.autoconfig;

import com.yczuoxin.springboot.test20.domain.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConditionalOnProperty(prefix = "person.2", name = "enabled", havingValue = "true", matchIfMissing = true)
public class Person2AutoConfiguration {

    @ConfigurationProperties(prefix = "person2")
    @Bean
    public Person person2() {
        return new Person();
    }

}
