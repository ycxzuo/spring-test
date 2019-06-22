package com.yczuoxin.springboot.test.client;

import com.yczuoxin.springboot.test.model.User;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class TestClient {
    public static void main(String[] args) {
        /**
         * 默认是 org.springframework.http.client.SimpleClientHttpRequestFactory
         */
        RestTemplate defaultTemplate = getRestTemplate();
        User user = defaultTemplate.getForObject("http://localhost:8888/user", User.class);
        System.out.println(user);

        System.out.println("---------------------------------------------");

        /**
         * 更改为 org.springframework.http.client.HttpComponentsClientHttpRequestFactory
         */
        RestTemplate httpComponentsClientTemplate = getHttpComponentsTemplate();
        User httpUser = httpComponentsClientTemplate.getForObject("http://localhost:8888/user", User.class);
        System.out.println(httpUser);
    }

    private static RestTemplate getHttpComponentsTemplate() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        HttpClient httpClient = builder.build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }

    private static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
