package com.example.minitest.Service;

import com.example.minitest.Model.Brand;
import com.example.minitest.Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductServiceImpl implements ProductService{
    private static final ArrayList<Product> products;
    private static final ArrayList<Brand> brands;
    private static Long INDEX;


    static{
    products = new ArrayList<>();
    brands = new ArrayList<>();
    brands.add(new Brand("Samsung"));
    brands.add(new Brand("Apple"));
    brands.add(new Brand("Nokia"));
    products.add(new Product(1L, "Galaxy S8", 2000D, brands.get(0), 5));
    products.add(new Product(2L, "Nokia 6300", 1000D, brands.get(2), 5));
    products.add(new Product(3L, "Iphone 12 pro", 2000D, brands.get(1), 5));
    INDEX = products.get(products.size() - 1).getId();
    }
    @Override
    public List<Product> findAll() {
        return products;
    }
    public List<Brand> findAllBrand() {
        return brands;
    }

    @Override
    public Product findById(Long id) {
        for(Product product: products){
            if (Objects.equals(product.getId(), id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(++INDEX);
        }
        products.add(product);
    }

    @Override
    public void delete(Long id) {
        products.remove(findById(id));
    }
}
