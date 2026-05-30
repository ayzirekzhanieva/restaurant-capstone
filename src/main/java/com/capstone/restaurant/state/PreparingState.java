package com.capstone.restaurant.state;

import com.capstone.restaurant.entity.Order;
import com.capstone.restaurant.entity.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class PreparingState implements OrderState {

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.PREPARING;
    }

    @Override
    public void moveToNextStatus(Order order) {
        order.updateStatus(OrderStatus.READY);
    }
}