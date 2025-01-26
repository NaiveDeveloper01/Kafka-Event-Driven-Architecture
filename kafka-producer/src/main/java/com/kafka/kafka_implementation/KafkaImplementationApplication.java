package com.kafka.kafka_implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class KafkaImplementationApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaImplementationApplication.class, args);
    }

}
