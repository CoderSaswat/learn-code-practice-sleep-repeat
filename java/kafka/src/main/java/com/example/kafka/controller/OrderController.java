//package com.example.kafka.controller;
//
//import com.example.kafka.model.Order;
//import com.example.kafka.producer.OrderProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/orders")
//public class OrderController {
//
//    @Autowired
//    private OrderProducer orderProducer;
//
//    @PostMapping
//    public ResponseEntity<String> sendOrder(@RequestBody Order order) {
//        orderProducer.sendOrder(order);
//        return ResponseEntity.ok("Order sent: " + order.getOrderId());
//    }
//}
