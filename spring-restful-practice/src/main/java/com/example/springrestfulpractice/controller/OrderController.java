package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.model.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @GetMapping("/{seq}")
    public Order getOrderBySeq(@PathVariable int seq) {
        return this.orderService.getOrderBySeq(seq);
    }

    @PostMapping()
    public Order createOrder(@RequestBody Order order) {
        return this.orderService.createOrder(order);
    }

    @PutMapping(value = "/{seq}")
    public Order updateOrder(@PathVariable int seq, @RequestBody Order order) {
        return this.orderService.updateOrder(seq, order);
    }

    @DeleteMapping("/{seq}")
    public Order deleteOrder(@PathVariable int seq) {
        return this.orderService.deleteOrder(seq);
    }
}
