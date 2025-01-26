package com.kafka.kafka_implementation.service;


import common_bundle.vo.KafkaMessage;
import common_bundle.vo.MessageData;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

public interface KafkaProducerService {
    CompletableFuture<SendResult<String, MessageData>> sendMessage(KafkaMessage kafkaMessage);
}
