package com.capstone.restaurant.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public DiscountType getType() {
        return DiscountType.NO_DISCOUNT;
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal totalAmount) {
        return totalAmount;
    }
}