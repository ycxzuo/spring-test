package com.yczuoxin.springboot.test11;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * bin/kafka-console-consumer.sh --bootstrap-server IP:9092 --topic test-1 --from-beginning
 */
public class KafkaTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","47.106.80.100:9092,47.106.146.28:9092,47.106.127.193:9092");
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer",StringSerializer.class);
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>("test-1",0,"message", "茂茂");
        Future<RecordMetadata> send = producer.send(record);
        RecordMetadata recordMetadata = send.get();
        System.out.println(recordMetadata);
    }
}
