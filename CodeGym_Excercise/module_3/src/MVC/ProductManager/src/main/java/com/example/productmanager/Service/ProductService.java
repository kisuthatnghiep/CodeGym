package com.example.productmanager.Service;

import com.example.productmanager.Model.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> findAll();
    void save(Product product);
    void update(int id);
    void delete(int id);

}
