package com.kafka.kafka_implementation.service.implementations;

import com.kafka.kafka_implementation.config.propertyconfigs.KafkaProducerPropertyConfig;
import com.kafka.kafka_implementation.service.KafkaProducerService;
import common_bundle.vo.KafkaMessage;
import common_bundle.vo.MessageData;
import common_bundle.vo.MessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaProducerServiceImpl implements KafkaProducerService {
    private final KafkaTemplate<String, MessageData> kafkaTemplate;
    private final KafkaProducerPropertyConfig kafkaProducerPropertyConfig;

    @Override
    public CompletableFuture<SendResult<String, MessageData>> sendMessage(KafkaMessage kafkaMessage) {
        MessageData messageData = kafkaMessage.getPayload();
        String key = kafkaMessage.getKey(String.valueOf(messageData.getProductCode()));
        Long timeMillis = System.currentTimeMillis();
        MessageProducer messageProducer = new MessageProducer(kafkaProducerPropertyConfig.getTopic(), kafkaProducerPropertyConfig.getPartitions(), timeMillis, key, messageData);
        return kafkaTemplate.send(messageProducer);
    }
}
