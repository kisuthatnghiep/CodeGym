package com.example.thuchanh.service;

import com.example.thuchanh.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    public final static HashMap<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1,"Thanh","thanh@gmail.com","Ha Dong"));
        customers.put(2, new Customer(2,"Huy","huy@gmail.com","Kham Thien"));
        customers.put(3, new Customer(3,"Tu","tu@gmail.com","Lao Cai"));
        customers.put(4, new Customer(4,"Quan","quan@gmail.com","My Dinh"));
        customers.put(5, new Customer(5,"Nam","nam@gmail.com","Dong Da"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId() ,customer);
    }

    @Override
    public void update(Customer customer, int id) {
        customers.put(id, customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
