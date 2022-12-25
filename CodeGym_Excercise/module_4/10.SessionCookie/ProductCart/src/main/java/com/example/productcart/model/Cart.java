package com.example.productcart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> carts = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> carts) {
        this.carts = carts;
    }

    public Map<Product, Integer> getCarts() {
        return carts;
    }

    public void setCarts(Map<Product, Integer> carts) {
        this.carts = carts;
    }

    private boolean checkItemInCart(Product product){
        for(Product product1: carts.keySet()){
            if (product1.getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : carts.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            carts.put(product, 1);
        }else {
            Map.Entry<Product, Integer> entry = selectItemInCart(product);
            Integer newQuantity = entry.getValue() +1;
            entry.setValue(newQuantity);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : carts.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return carts.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : carts.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

}
