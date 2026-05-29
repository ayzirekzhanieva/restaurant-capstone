package com.capstone.restaurant.controller;

import com.capstone.restaurant.dto.request.MenuItemRequest;
import com.capstone.restaurant.dto.response.MenuItemResponse;
import com.capstone.restaurant.service.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public MenuItemResponse create(@Valid @RequestBody MenuItemRequest request) {
        return menuItemService.create(request);
    }

    @GetMapping
    public List<MenuItemResponse> getAll() {
        return menuItemService.getAll();
    }

    @GetMapping("/{id}")
    public MenuItemResponse getById(@PathVariable Long id) {
        return menuItemService.getById(id);
    }

    @PutMapping("/{id}")
    public MenuItemResponse update(
            @PathVariable Long id,
            @Valid @RequestBody MenuItemRequest request
    ) {
        return menuItemService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        menuItemService.delete(id);
    }
}