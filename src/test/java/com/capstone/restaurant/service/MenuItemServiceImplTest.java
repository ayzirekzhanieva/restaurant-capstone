package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.MenuItemRequest;
import com.capstone.restaurant.dto.response.MenuItemResponse;
import com.capstone.restaurant.entity.MenuItem;
import com.capstone.restaurant.repository.MenuItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuItemServiceImplTest {

    @Mock
    private MenuItemRepository menuItemRepository;

    @InjectMocks
    private MenuItemServiceImpl menuItemService;

    @Test
    void create_ShouldReturnMenuItemResponse() throws Exception {

        MenuItemRequest request = new MenuItemRequest();

        setField(request, "name", "Burger");
        setField(request, "description", "Cheese Burger");
        setField(request, "price", BigDecimal.valueOf(8.99));

        MenuItem savedItem = new MenuItem(
                "Burger",
                "Cheese Burger",
                BigDecimal.valueOf(8.99)
        );

        setField(savedItem, "id", 1L);

        when(menuItemRepository.save(org.mockito.ArgumentMatchers.any(MenuItem.class)))
                .thenReturn(savedItem);

        MenuItemResponse response = menuItemService.create(request);

        assertEquals(1L, response.getId());
        assertEquals("Burger", response.getName());
        assertEquals("Cheese Burger", response.getDescription());
        assertEquals(BigDecimal.valueOf(8.99), response.getPrice());
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}