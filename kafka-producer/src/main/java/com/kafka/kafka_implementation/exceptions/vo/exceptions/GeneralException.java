package com.kafka.kafka_implementation.exceptions.vo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GeneralException {
    private String statusCode;
    private String errorMessage;
    private String errorDescription;
}
