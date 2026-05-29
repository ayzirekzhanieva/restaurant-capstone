package com.capstone.restaurant.dto.response;

import java.math.BigDecimal;

public class OrderItemResponse {

    private Long menuItemId;
    private String menuItemName;
    private int quantity;
    private BigDecimal price;

    public OrderItemResponse(Long menuItemId, String menuItemName, int quantity, BigDecimal price) {
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}