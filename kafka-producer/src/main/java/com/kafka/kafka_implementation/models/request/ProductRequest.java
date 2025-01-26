package com.kafka.kafka_implementation.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long productCode;
    private String name;
    private String category;
    private Double cost;
}
