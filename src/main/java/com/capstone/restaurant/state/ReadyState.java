package com.capstone.restaurant.state;

import com.capstone.restaurant.entity.Order;
import com.capstone.restaurant.entity.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class ReadyState implements OrderState {

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.READY;
    }

    @Override
    public void moveToNextStatus(Order order) {
        order.updateStatus(OrderStatus.DELIVERED);
    }
}