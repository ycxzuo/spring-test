package com.yczuoxin.springboot.test20.autoconfig;

import com.yczuoxin.springboot.test20.domain.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
//@ConditionalOnProperty(prefix = "person", name = "enabled", havingValue = "true", matchIfMissing = true)
public class PersonAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "person")
    public Person person(){
         return new Person();
    }

}
