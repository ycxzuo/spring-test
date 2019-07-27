package com.yczuoxin.springboot.test14.client;

import com.yczuoxin.springboot.test14.domain.User;
import com.yczuoxin.springboot.test14.domain.UserIdRequest;
import com.yczuoxin.springboot.test14.domain.UserResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.time.Instant;

public class WebservicesClient {
    public static void main(String[] args) {
        WebServiceTemplate template = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setClassesToBeBound(User.class, UserIdRequest.class, UserResponse.class);

        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);

        UserIdRequest request = new UserIdRequest();
        request.setUserId(1L);
        request.setTimestamp(Instant.now().toEpochMilli());

        UserResponse result = (UserResponse)template.marshalSendAndReceive("http://localhost:8080/serivces/web-service/user", request);
        System.out.println(result.getUser());
        System.out.println(result.getTimestamp());
    }
}
