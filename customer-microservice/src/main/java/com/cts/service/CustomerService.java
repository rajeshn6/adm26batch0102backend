package com.cts.service;

import com.cts.dto.UpdateCustomerRequest;
import com.cts.entity.Customer;
import com.cts.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerByUserId(String userId) {
        return customerRepository.findByUserId(userId)
            .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    @Transactional
    public Customer updateCustomer(String userId, UpdateCustomerRequest request) {
        Customer customer = customerRepository.findByUserId(userId)
            .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        // Check if email is being changed and if it's already taken by another user
        if (!customer.getEmail().equals(request.getEmail()) && 
            customerRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        customer.setName(request.getName());
        customer.setEmail(request.getEmail());

        return customerRepository.save(customer);
    }
}
