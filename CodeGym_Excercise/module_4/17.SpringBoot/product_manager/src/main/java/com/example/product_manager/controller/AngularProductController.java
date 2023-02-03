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
    public ResponseEntity<List<Product>> index(){
        List<Product> products =(List<Product>) productService.findAll();
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchProduct(@RequestParam("q") Optional<String> q){
        if (q.isPresent()){
            List<Product> productList =(List<Product>)productService.search(q.get());
            if (productList.isEmpty()){
                return new ResponseEntity<>(productList, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product){
        if (product.getImg() == null){
            product.setImg("http://www.clker.com/cliparts/u/v/4/T/s/r/cartoon-mobile-phone1-md.png");
        }
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> product= productService.findById(id);
        if (!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    public ResponseEntity<List<Product>> findByCategory(@PathVariable Long id){
        return new  ResponseEntity<>(productService.findProductByCategory(categoryService.findById(id).get()), HttpStatus.OK);
    }
}
