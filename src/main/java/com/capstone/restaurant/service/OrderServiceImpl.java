package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.CreateOrderRequest;
import com.capstone.restaurant.dto.response.OrderItemResponse;
import com.capstone.restaurant.dto.response.OrderResponse;
import com.capstone.restaurant.entity.Customer;
import com.capstone.restaurant.entity.MenuItem;
import com.capstone.restaurant.entity.Order;
import com.capstone.restaurant.entity.OrderItem;
import com.capstone.restaurant.repository.CustomerRepository;
import com.capstone.restaurant.repository.MenuItemRepository;
import com.capstone.restaurant.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            CustomerRepository customerRepository,
            MenuItemRepository menuItemRepository
    ) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public OrderResponse createOrder(CreateOrderRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow();

        Order order = new Order(customer);

        request.getItems().forEach(itemRequest -> {
            MenuItem menuItem = menuItemRepository.findById(itemRequest.getMenuItemId())
                    .orElseThrow();

            OrderItem orderItem = new OrderItem(menuItem, itemRequest.getQuantity());
            order.addItem(orderItem);
        });

        Order savedOrder = orderRepository.save(order);

        return mapToResponse(savedOrder);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow();

        return mapToResponse(order);
    }

    private OrderResponse mapToResponse(Order order) {

        List<OrderItemResponse> itemResponses = order.getItems()
                .stream()
                .map(item -> new OrderItemResponse(
                        item.getMenuItem().getId(),
                        item.getMenuItem().getName(),
                        item.getQuantity(),
                        item.getPrice()
                ))
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getCustomer().getId(),
                order.getCustomer().getFullName(),
                order.getStatus(),
                order.getTotalAmount(),
                itemResponses
        );
    }
    @Override
    public OrderResponse updateOrderStatus(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow();

        switch (order.getStatus()) {
            case RECEIVED -> order.updateStatus(com.capstone.restaurant.entity.OrderStatus.PREPARING);
            case PREPARING -> order.updateStatus(com.capstone.restaurant.entity.OrderStatus.READY);
            case READY -> order.updateStatus(com.capstone.restaurant.entity.OrderStatus.DELIVERED);
            case DELIVERED -> throw new IllegalStateException("Order is already delivered");
        }

        Order savedOrder = orderRepository.save(order);

        return mapToResponse(savedOrder);
    }
}