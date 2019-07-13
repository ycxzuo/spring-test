package com.yczuoxin.springboot.test10.repository.impl;

import com.yczuoxin.springboot.test10.entity.Person;
import com.yczuoxin.springboot.test10.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    private HashMap<String, Person> map = new HashMap<>();

    @Override
    public Person findById(String id) {
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public boolean save(Person person) {
        redisTemplate.opsForValue().set(person.getId(), person);
        return true;
    }
}
