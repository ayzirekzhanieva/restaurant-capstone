package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.CreateOrderRequest;
import com.capstone.restaurant.dto.request.OrderItemRequest;
import com.capstone.restaurant.dto.response.OrderResponse;
import com.capstone.restaurant.entity.Customer;
import com.capstone.restaurant.entity.MenuItem;
import com.capstone.restaurant.entity.Order;
import com.capstone.restaurant.repository.CustomerRepository;
import com.capstone.restaurant.repository.MenuItemRepository;
import com.capstone.restaurant.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private MenuItemRepository menuItemRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void createOrder_ShouldReturnOrderResponse() throws Exception {
        CreateOrderRequest request = new CreateOrderRequest();
        OrderItemRequest itemRequest = new OrderItemRequest();

        setField(request, "customerId", 1L);
        setField(itemRequest, "menuItemId", 1L);
        setField(itemRequest, "quantity", 2);
        setField(request, "items", List.of(itemRequest));

        Customer customer = new Customer("John Smith", "john@example.com", "123456789");
        setField(customer, "id", 1L);

        MenuItem menuItem = new MenuItem("Burger", "Cheese Burger", BigDecimal.valueOf(8.99));
        setField(menuItem, "id", 1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(menuItemRepository.findById(1L)).thenReturn(Optional.of(menuItem));
        when(orderRepository.save(org.mockito.ArgumentMatchers.any(Order.class)))
                .thenAnswer(invocation -> {
                    Order order = invocation.getArgument(0);
                    setField(order, "id", 1L);
                    return order;
                });

        OrderResponse response = orderService.createOrder(request);

        assertEquals(1L, response.getId());
        assertEquals(1L, response.getCustomerId());
        assertEquals("John Smith", response.getCustomerName());
        assertEquals(BigDecimal.valueOf(17.98), response.getTotalAmount());
        assertEquals(1, response.getItems().size());
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}