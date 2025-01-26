package com.kafka.kafka_implementation.config.propertyconfigs;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "kafka.values")
@Getter
@Setter(onMethod_ = {@Synchronized})
@AllArgsConstructor
@NoArgsConstructor
public class KafkaProducerPropertyConfig {
    private String topic;
    private int partitions;
    private int replica;
}
