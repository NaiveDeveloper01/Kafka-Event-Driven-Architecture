package email.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {
    @KafkaListener(topics = "product-create-topic", groupId = "product-create-topic-Id")
    public void consume(String messageData) {
        System.out.println(messageData);
    }
}
