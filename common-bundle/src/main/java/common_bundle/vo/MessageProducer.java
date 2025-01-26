package common_bundle.vo;

import org.apache.kafka.clients.producer.ProducerRecord;

public class MessageProducer extends ProducerRecord<String, MessageData> {
    public MessageProducer(String topic, Integer partition, Long timestamp, String key, MessageData value) {
        super(topic, partition, timestamp, key, value);
    }
}
