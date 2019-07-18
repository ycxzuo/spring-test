package com.yczuoxin.springboot.test11.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @KafkaListener(topics = "springboot-test")
    public void consumer(String message){
        System.err.println("consumer : " + message);
    }

    @KafkaListener(topics = "springboot-object")
    public void consumer(Object object){
        System.err.println("consumer : " + object);
    }
}
