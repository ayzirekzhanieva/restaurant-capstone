package com.capstone.restaurant.dto.response;

import com.capstone.restaurant.entity.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public class OrderResponse {

    private Long id;
    private Long customerId;
    private String customerName;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private List<OrderItemResponse> items;

    public OrderResponse(
            Long id,
            Long customerId,
            String customerName,
            OrderStatus status,
            BigDecimal totalAmount,
            List<OrderItemResponse> items
    ) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.status = status;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }
}