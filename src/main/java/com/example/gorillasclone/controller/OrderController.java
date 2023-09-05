package com.example.gorillasclone.controller;
import com.example.gorillasclone.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    List<Order> orderList = new ArrayList<Order>();
    private int orderIdCounter = 1;
    @GetMapping("/orders")
    List<Order> orderList() {
        return orderList;
    }

    @GetMapping("/orders/{id}")
    Order order(@PathVariable int id){
        Optional<Order> result = orderList.stream().filter(order -> order.id() == id).findFirst();
        return result.orElse(null);
    }

    @PostMapping("/orders")
    Order newOrder(String customerName) {
        Order order = new Order(orderIdCounter, "Jahkaan Wray");
        orderList.add(order);
        orderIdCounter++;
        return order;
    }
}