package com.yczuoxin.springboot.test14.repository;

import com.yczuoxin.springboot.test14.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private Map<Long, User> userCache = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        User user = createUser(1, "左昕", 27);
        User user2 = createUser(2, "刘德华", null);
        User user3 = createUser(3, "黄晓明", null);
        userCache.put(1L, user);
        userCache.put(2L, user2);
        userCache.put(3L, user3);
    }

    public User getById(long id) {
        return userCache.get(id);
    }

    private User createUser(long id, String name, Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }

}
