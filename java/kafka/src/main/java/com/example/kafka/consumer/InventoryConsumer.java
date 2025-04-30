//package com.example.kafka.consumer;
//
//import com.example.kafka.model.Order;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class InventoryConsumer {
//
//    @KafkaListener(topics = "order-events", groupId = "inventory-group", containerFactory = "orderKafkaListenerContainerFactory")
//    public void handleOrder(Order order) {
//        System.out.println("Inventory received order: " + order.getOrderId() + " - " + order.getProduct());
//    }
//}
