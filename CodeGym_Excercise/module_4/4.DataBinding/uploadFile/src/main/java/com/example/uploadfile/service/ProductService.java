package com.example.uploadfile.service;

import com.example.uploadfile.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService{

    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p = product;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        products.remove(findById(id));
    }
}
