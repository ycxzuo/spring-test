package com.yczuoxin.springboot.test10.repository;

import com.yczuoxin.springboot.test10.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "people")
    Person findById(String id);

    boolean save(Person person);
}
