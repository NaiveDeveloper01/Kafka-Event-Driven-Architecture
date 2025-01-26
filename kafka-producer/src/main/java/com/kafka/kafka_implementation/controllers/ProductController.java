package com.kafka.kafka_implementation.controllers;

import com.kafka.kafka_implementation.models.request.ProductRequest;
import com.kafka.kafka_implementation.models.response.ProductResponse;
import com.kafka.kafka_implementation.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "shop-market/product")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ProductController {
    private final ProductService productService;

    @PostMapping(path = "create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();
        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.CREATED);
    }
}
