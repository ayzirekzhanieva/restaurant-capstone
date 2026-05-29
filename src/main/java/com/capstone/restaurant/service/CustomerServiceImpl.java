package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.CustomerRequest;
import com.capstone.restaurant.dto.response.CustomerResponse;
import com.capstone.restaurant.entity.Customer;
import com.capstone.restaurant.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.capstone.restaurant.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse create(CustomerRequest request) {

        Customer customer = new Customer(
                request.getFullName(),
                request.getEmail(),
                request.getPhone()
        );

        customer = customerRepository.save(customer);

        return new CustomerResponse(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> new CustomerResponse(
                        customer.getId(),
                        customer.getFullName(),
                        customer.getEmail(),
                        customer.getPhone()))
                .toList();
    }

    @Override
    public CustomerResponse getById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id " + id
                        ));

        return new CustomerResponse(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id " + id
                        ));

        customer.updateContactInfo(
                request.getFullName(),
                request.getEmail(),
                request.getPhone()
        );

        customerRepository.save(customer);

        return new CustomerResponse(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}