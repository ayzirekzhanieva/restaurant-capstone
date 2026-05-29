package com.capstone.restaurant.strategy;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountStrategyFactory {

    private final List<DiscountStrategy> strategies;

    public DiscountStrategyFactory(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    public DiscountStrategy getStrategy(DiscountType type) {
        return strategies.stream()
                .filter(strategy -> strategy.getType() == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported discount type: " + type));
    }
}