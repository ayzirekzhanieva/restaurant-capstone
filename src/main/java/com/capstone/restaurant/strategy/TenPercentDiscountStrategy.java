package com.capstone.restaurant.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TenPercentDiscountStrategy implements DiscountStrategy {

    @Override
    public DiscountType getType() {
        return DiscountType.PERCENT_10;
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal totalAmount) {
        return totalAmount.multiply(BigDecimal.valueOf(0.90));
    }
}