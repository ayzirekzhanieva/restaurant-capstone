package com.capstone.restaurant.strategy;

import java.math.BigDecimal;

public interface DiscountStrategy {

    DiscountType getType();

    BigDecimal applyDiscount(BigDecimal totalAmount);
}