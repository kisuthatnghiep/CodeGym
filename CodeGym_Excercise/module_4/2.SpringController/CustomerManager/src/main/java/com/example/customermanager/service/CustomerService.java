package com.example.customermanager.service;

import com.example.customermanager.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomerService {
    private static ArrayList<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer(1L,"Thanh","thanh@gmail.com","Ha Dong"));
        customers.add(new Customer(2L,"Quang","quang@gmail.com","Ha Dong"));
        customers.add(new Customer(3L,"Huy","huy@gmail.com","Kham Thien"));
        customers.add(new Customer(4L,"Tu","tu@gmail.com","Dong Da"));
    }

    public ArrayList<Customer> findAll(){
        return customers;
    }

    public Customer findById(Long id){
        for (Customer customer: customers){
            if (customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }
}
