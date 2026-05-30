package com.capstone.restaurant.state;

import com.capstone.restaurant.entity.Order;
import com.capstone.restaurant.entity.OrderStatus;

public interface OrderState {

    OrderStatus getStatus();

    void moveToNextStatus(Order order);
}