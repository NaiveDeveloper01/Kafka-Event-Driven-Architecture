package common_bundle.vo;


import lombok.Builder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;


@Builder
public class KafkaMessage implements Message<MessageData> {
    private MessageData payload;
    private MessageHeaders messageHeaders;


    public void setMessageHeaders(Map<String, Object> data) {
        this.messageHeaders = new MessageHeaders(data);
    }

    public String getKey(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MessageData getPayload() {
        return payload;
    }

    @Override
    public MessageHeaders getHeaders() {
        return messageHeaders;
    }
}
