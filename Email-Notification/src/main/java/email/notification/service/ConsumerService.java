package email.notification.service;

import common_bundle.vo.MessageData;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerService {
    @KafkaListener(topics = "product-create-topic")
    public void consume(MessageData messageData) {

    }
}
