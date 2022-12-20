package com.example.thuchanh.service;

import com.example.thuchanh.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void update(Customer customer, int id);
    Customer findById(int id);
    void remove(int id);
}
