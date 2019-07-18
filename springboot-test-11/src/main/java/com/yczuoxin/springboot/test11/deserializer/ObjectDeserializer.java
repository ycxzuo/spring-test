package com.yczuoxin.springboot.test11.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class ObjectDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        Object object;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            object = objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("topic : " + topic + " , object : " + object);
        return object;
    }

    @Override
    public void close() {

    }
}
