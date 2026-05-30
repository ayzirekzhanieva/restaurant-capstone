package com.capstone.restaurant.state;

import com.capstone.restaurant.entity.Order;
import com.capstone.restaurant.entity.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class DeliveredState implements OrderState {

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.DELIVERED;
    }

    @Override
    public void moveToNextStatus(Order order) {
        throw new IllegalStateException(
                "Delivered order cannot change status"
        );
    }
}