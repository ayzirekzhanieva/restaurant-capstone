package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.MenuItemRequest;
import com.capstone.restaurant.dto.response.MenuItemResponse;

import java.util.List;

public interface MenuItemService {

    MenuItemResponse create(MenuItemRequest request);

    List<MenuItemResponse> getAll();

    MenuItemResponse getById(Long id);

    MenuItemResponse update(Long id, MenuItemRequest request);

    void delete(Long id);
}