package com.kafka.kafka_implementation.service.implementations;

import com.kafka.kafka_implementation.models.request.ProductRequest;
import com.kafka.kafka_implementation.models.response.ProductResponse;
import com.kafka.kafka_implementation.service.KafkaProducerService;
import com.kafka.kafka_implementation.service.ProductService;
import com.kafka.kafka_implementation.vo.Product;
import common_bundle.vo.KafkaMessage;
import common_bundle.vo.MessageData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ProductServiceImpl implements ProductService {
    private final KafkaProducerService kafkaProducerService;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        MessageData messageData = MessageData.builder()
                .productName(product.getName())
                .productCategory(product.getCategory())
                .productCode(product.getProductCode())
                .productCost(product.getCost())
                .build();
        KafkaMessage kafkaMessage = KafkaMessage.builder()
                .payload(messageData)
                .build();
        // code to save product to DB
        CompletableFuture<SendResult<String, MessageData>> resultCompletableFuture = kafkaProducerService.sendMessage(kafkaMessage);
        resultCompletableFuture.whenComplete((res, exception) -> {
            if (exception != null) {
                log.info("Fail to send message to kafka");
            } else {
                log.info("Message sent successfully to kafka");
            }
        });
        return null;
    }
}
