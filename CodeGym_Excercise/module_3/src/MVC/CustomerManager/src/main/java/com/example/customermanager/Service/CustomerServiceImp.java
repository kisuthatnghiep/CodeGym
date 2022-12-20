package com.example.customermanager.Service;

import com.example.customermanager.Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImp implements CustomerService {

    private static final Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1,"Thanh","thanh@gmail.com","Ha Dong"));
        customers.put(2, new Customer(2,"Huy","huy@gmail.com","Kham Thien"));
        customers.put(3, new Customer(3,"Tu","tu@gmail.com","My Dinh"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
