//package com.example.kafka.producer;
//
//import com.example.kafka.model.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderProducer {
//    private static final String TOPIC = "order-events";
//
//    @Autowired
//    private KafkaTemplate<String, Order> kafkaTemplate;
//
//    public void sendOrder(Order order) {
//        kafkaTemplate.send(TOPIC, order);
//    }
//}
