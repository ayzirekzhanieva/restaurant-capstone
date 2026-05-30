package com.capstone.restaurant.state;

import com.capstone.restaurant.entity.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderStateFactory {

    private final List<OrderState> states;

    public OrderStateFactory(List<OrderState> states) {
        this.states = states;
    }

    public OrderState getState(OrderStatus status) {
        return states.stream()
                .filter(state -> state.getStatus() == status)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported order status: " + status));
    }
}