package com.example.customerlist.Service;

import com.example.customerlist.Model.Customer;

import java.util.ArrayList;

public class CustomerService {
    public static final ArrayList<Customer> customers;
    static {
        customers = new ArrayList<>();
        customers.add(new Customer("Thanh", "23/11/1999","Ha Dong","img/Avatar-Facebook-trắng.jpg"));
        customers.add(new Customer("Huy", "23/11/1999","Ha Dong","img/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg"));
        customers.add(new Customer("Tu", "23/11/1999","Ha Dong","img/trend-avatar-1.jpg"));
    }

    public ArrayList<Customer> display(){
        return customers;
    }
}
