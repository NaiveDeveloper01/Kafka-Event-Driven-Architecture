package com.kafka.kafka_implementation.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long productCode;
    private String name;
    private String category;
    private Double cost;
}
