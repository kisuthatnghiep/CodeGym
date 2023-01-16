package com.example.product_manager.controller;

import com.example.product_manager.model.Category;
import com.example.product_manager.model.Product;
import com.example.product_manager.service.ICategoryService;
import com.example.product_manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
@PropertySource("classpath:application.properties")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Value("${upload.path}")
    private String link;
    @Value("${display.path}")
    private String displayLink;
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
    public ResponseEntity<String> create(@RequestPart("product") Product product, @RequestPart(value = "file", required = false) MultipartFile file){
        uploadFile(product, file);
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
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestPart("product") Product product, @RequestPart(value = "file", required = false) MultipartFile file) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        uploadFile(product, file);
        if (product.getImg() == null){
            product.setImg(productOptional.get().getImg());
        }
        product.setId(productOptional.get().getId());
        productService.save(product);
        return new ResponseEntity<>("Update successfully!", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }

    private void uploadFile(Product product, MultipartFile file){
        if (file != null) {
            String fileName = file.getOriginalFilename();
            try {
                FileCopyUtils.copy(file.getBytes(), new File(link + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            product.setImg(displayLink + fileName);
        } else {
            product.setImg(displayLink + "iphone.jpg");
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> findbyCategory(@PathVariable Long id){
        return new  ResponseEntity<>(productService.findProductByCategory(categoryService.findById(id).get()), HttpStatus.OK);
    }
}