package com.capstone.restaurant.service;

import com.capstone.restaurant.dto.request.CustomerRequest;
import com.capstone.restaurant.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse create(CustomerRequest request);

    List<CustomerResponse> getAll();

    CustomerResponse getById(Long id);

    CustomerResponse update(Long id, CustomerRequest request);

    void delete(Long id);
}