package com.example.product_manager.controller;

import com.example.product_manager.model.Category;
import com.example.product_manager.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<Iterable<Category>> index(){
        List<Category> categories =(List<Category>) categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>("Create category successfully!", HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Category> category= categoryService.findById(id);
        if (!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>("Delete category successfully!", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryOptional.get().getId());
        categoryService.save(category);
        return new ResponseEntity<>("Update successfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id).get(), HttpStatus.OK);
    }
}
