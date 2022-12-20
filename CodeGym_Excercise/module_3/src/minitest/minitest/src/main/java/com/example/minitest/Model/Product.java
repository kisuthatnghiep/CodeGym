package com.example.minitest.Model;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Brand brand;
    private Integer quantity;

    public Product(String name, Double price, Brand brand, Integer quantity) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
    }

    public Product(Long id, String name, Double price, Brand brand, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
