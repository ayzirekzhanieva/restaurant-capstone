package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.MenuItemRequest;
import com.capstone.restaurant.dto.response.MenuItemResponse;
import com.capstone.restaurant.entity.MenuItem;
import com.capstone.restaurant.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public MenuItemResponse create(MenuItemRequest request) {

        MenuItem menuItem = new MenuItem(
                request.getName(),
                request.getDescription(),
                request.getPrice()
        );

        menuItem = menuItemRepository.save(menuItem);

        return new MenuItemResponse(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.getPrice()
        );
    }

    @Override
    public List<MenuItemResponse> getAll() {
        return menuItemRepository.findAll()
                .stream()
                .map(item -> new MenuItemResponse(
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getPrice()))
                .toList();
    }

    @Override
    public MenuItemResponse getById(Long id) {

        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow();

        return new MenuItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice()
        );
    }

    @Override
    public MenuItemResponse update(Long id, MenuItemRequest request) {

        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow();

        item.update(
                request.getName(),
                request.getDescription(),
                request.getPrice()
        );

        menuItemRepository.save(item);

        return new MenuItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice()
        );
    }

    @Override
    public void delete(Long id) {
        menuItemRepository.deleteById(id);
    }
}