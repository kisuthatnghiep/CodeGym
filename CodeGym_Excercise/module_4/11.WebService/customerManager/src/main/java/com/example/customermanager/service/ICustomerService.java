package com.example.customermanager.service;

import com.example.customermanager.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    void remove(Long id);
}
