package com.example.productcategory.service;

import com.example.productcategory.model.Category;
import com.example.productcategory.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    private static final List<Product> products;
    private static final List<Category> categories;
    static {
        products = new ArrayList<>();
        categories = new ArrayList<>();
        categories.add(new Category(1, "Apple"));
        categories.add(new Category(2, "Samsung"));
        categories.add(new Category(3, "Nokia"));
        products.add(new Product(1L,"Iphone X", 20D, 5, categories.get(0)));
        products.add(new Product(2L,"Galaxy S8", 15D, 10, categories.get(1)));
        products.add(new Product(3L,"Lumia", 10D, 3, categories.get(2)));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        for (Product product: products){
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null){
            product.setId((long) (products.size() +1));
//            product.setCategory();
            products.add(product);
        }else {
            products.set(products.indexOf(findById(product.getId())),product);
        }
    }

    @Override
    public void remove(Long id) {
        products.remove(findById(id));
    }

    @Override
    public List<Category> findAllCategories() {
        return categories;
    }

    @Override
    public Category findCategoryById(int id) {
        for (Category category: categories){
            if (category.getId() == id){
                return category;
            }
        }
        return null;
    }

    public List<Product> search(String search){
        List<Product> p = new ArrayList<>();
        for (Product product: products){
            if (product.getName().toLowerCase().contains(search.toLowerCase())){
                p.add(product);
            }
        }
        return p;
    }
}
