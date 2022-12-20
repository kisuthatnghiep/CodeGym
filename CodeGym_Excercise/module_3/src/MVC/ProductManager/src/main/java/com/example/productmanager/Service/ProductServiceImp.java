package com.example.productmanager.Service;

import com.example.productmanager.Model.Product;

import java.util.ArrayList;

public class ProductServiceImp implements ProductService{

    static final ArrayList<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1,"iphone",2000,"red","Apple"));
    }

    @Override
    public ArrayList<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
            products.add(product);
    }


    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
