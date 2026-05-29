package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.CustomerRequest;
import com.capstone.restaurant.dto.response.CustomerResponse;
import com.capstone.restaurant.entity.Customer;
import com.capstone.restaurant.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void create_ShouldReturnCustomerResponse() throws Exception {
        CustomerRequest request = new CustomerRequest();

        setField(request, "fullName", "John Smith");
        setField(request, "email", "john@example.com");
        setField(request, "phone", "123456789");

        Customer savedCustomer = new Customer(
                "John Smith",
                "john@example.com",
                "123456789"
        );

        setField(savedCustomer, "id", 1L);

        when(customerRepository.save(org.mockito.ArgumentMatchers.any(Customer.class)))
                .thenReturn(savedCustomer);

        CustomerResponse response = customerService.create(request);

        assertEquals(1L, response.getId());
        assertEquals("John Smith", response.getFullName());
        assertEquals("john@example.com", response.getEmail());
        assertEquals("123456789", response.getPhone());
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}