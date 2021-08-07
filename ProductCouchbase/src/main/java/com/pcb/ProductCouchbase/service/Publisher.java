package com.pcb.ProductCouchbase.service;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Publisher {

    @Value("${kafka.topic.productPriceChange}")
    private String topic;
    @Value("${kafka.topic.productStockAlert}")
    private String stockAlert;
    @Value("${kafka.topic.productOutOfStock}")
    private String OutOfStock;

    private final KafkaTemplate kafkaTemplate;

    public Publisher(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishProductPriceChangeEvent(String msg) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), msg);
    }
    public void publishStockChangeEvent(String msg) {
        kafkaTemplate.send(stockAlert,UUID.randomUUID().toString(), msg);
    }
    public void publishOutOfStockEvent(String msg){
        kafkaTemplate.send(OutOfStock,UUID.randomUUID().toString(), msg);
    }
}
