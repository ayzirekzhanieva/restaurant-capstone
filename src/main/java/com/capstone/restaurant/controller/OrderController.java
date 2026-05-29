package com.capstone.restaurant.controller;

import com.capstone.restaurant.dto.request.CreateOrderRequest;
import com.capstone.restaurant.dto.response.OrderResponse;
import com.capstone.restaurant.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @PatchMapping("/{id}/status")
    public OrderResponse updateOrderStatus(@PathVariable Long id) {
        return orderService.updateOrderStatus(id);
    }
}