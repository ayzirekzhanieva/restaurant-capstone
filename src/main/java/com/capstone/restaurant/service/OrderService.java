package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.CreateOrderRequest;
import com.capstone.restaurant.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(CreateOrderRequest request);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);

    OrderResponse updateOrderStatus(Long id);
}