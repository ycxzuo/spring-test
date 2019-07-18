package com.yczuoxin.springboot.test11.serializer;

import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class ObjectSerializer implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {
        if (data == null) {
            return new byte[0];
        }

        System.out.println("topic : " + topic + " , data : " + data);
        byte [] dataArray;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            dataArray = outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return dataArray;
    }

    @Override
    public void close() {

    }
}
