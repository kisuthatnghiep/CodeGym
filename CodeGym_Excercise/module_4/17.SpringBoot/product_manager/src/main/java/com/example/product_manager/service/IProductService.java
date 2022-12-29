package com.example.product_manager.service;

import com.example.product_manager.model.Product;

public interface IProductService extends IGeneralService<Product> {
    public Iterable<Product> search(String name);
}
