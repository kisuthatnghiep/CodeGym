package com.example.product_manager.repository;

import com.example.product_manager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> searchProductsByNameContaining(String name);
}
