package com.example.productcategory.service;

import com.example.productcategory.model.Category;
import com.example.productcategory.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void remove(Long id);
    List<Category> findAllCategories();
    Category findCategoryById(int id);
}
