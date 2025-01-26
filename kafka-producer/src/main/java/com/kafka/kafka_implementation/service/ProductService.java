package com.kafka.kafka_implementation.service;

import com.kafka.kafka_implementation.models.request.ProductRequest;
import com.kafka.kafka_implementation.models.response.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
}
