package com.example.product_manager.service;

import com.example.product_manager.model.Category;
import com.example.product_manager.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    public Iterable<Product> search(String name);
    List<Product> findProductByCategory(Category category);
}
