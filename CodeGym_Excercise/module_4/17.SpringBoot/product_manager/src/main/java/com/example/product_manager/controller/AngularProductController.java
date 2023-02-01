package com.example.product_manager.controller;

import com.example.product_manager.model.Category;
import com.example.product_manager.model.Product;
import com.example.product_manager.service.ICategoryService;
import com.example.product_manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class AngularProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<Object> index(){
        List<Product> products =(List<Product>) productService.findAll();
        List<Category> categories =(List<Category>) categoryService.findAll();
        List<Object> objects = new ArrayList<>();
        objects.add(products);
        objects.add(categories);
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchProduct(@RequestParam("q") Optional<String> q){
        List<Object> objects = new ArrayList<>();
        if (q.isPresent()){
            List<Product> productList =(List<Product>)productService.search(q.get());
            objects.add(productList);
            objects.add(categoryService.findAll());
            if (productList.isEmpty()){
                return new ResponseEntity<>(objects, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(objects, HttpStatus.OK);
        }
        objects.add(productService.findAll());
        objects.add(categoryService.findAll());
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>("Create product successfully!", HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Product> product= productService.findById(id);
        if (!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>("Delete product successfully!", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (product.getImg() == null){
            product.setImg(productOptional.get().getImg());
        }
        product.setId(productOptional.get().getId());
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> findbyCategory(@PathVariable Long id){
        return new  ResponseEntity<>(productService.findProductByCategory(categoryService.findById(id).get()), HttpStatus.OK);
    }
}
