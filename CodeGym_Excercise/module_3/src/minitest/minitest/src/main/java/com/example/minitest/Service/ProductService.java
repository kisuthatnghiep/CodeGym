package com.example.minitest.Service;

import com.example.minitest.Model.Product;

import java.util.List;

public interface ProductService<E> {
    List<E> findAll();
    E findById(Long id);
    void save(Product product);
    void delete(Long id);
}
