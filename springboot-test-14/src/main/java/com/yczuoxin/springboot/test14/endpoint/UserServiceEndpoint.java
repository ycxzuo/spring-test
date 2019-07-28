package com.yczuoxin.springboot.test14.endpoint;

import com.yczuoxin.springboot.test14.domain.User;
import com.yczuoxin.springboot.test14.domain.UserIdRequest;
import com.yczuoxin.springboot.test14.domain.UserResponse;
import com.yczuoxin.springboot.test14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Endpoint
public class UserServiceEndpoint {

    @Autowired
    private UserRepository userRepository;

    @PayloadRoot(namespace = "http://www.yczuoxin.com/schemas", localPart = "userIdRequest")
    @ResponsePayload
    public UserResponse getUser(@RequestPayload UserIdRequest userIdRequest) {
        long userId = userIdRequest.getUserId();

        Instant instant = Instant.ofEpochMilli(userIdRequest.getTimestamp());
        ZonedDateTime time = instant.atZone(ZoneId.systemDefault());

        System.out.println("获取用户Id: " + userId + ", 获取时间: " + time);

        User user = userRepository.getById(userId);

        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);
        userResponse.setTimestamp(Instant.now().toEpochMilli());
        return userResponse;
    }

}
