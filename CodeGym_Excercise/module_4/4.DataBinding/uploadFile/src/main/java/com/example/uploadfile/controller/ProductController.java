package com.example.uploadfile.controller;

import com.example.uploadfile.model.Product;
import com.example.uploadfile.model.ProductForm;
import com.example.uploadfile.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/products")
public class ProductController {
@Autowired
    private ProductService productService;
@Value("${file-upload}")
    private String fileUpload;

@GetMapping
    public String index(Model model){
    model.addAttribute("products",productService.findAll());
    return "/index";
}

@RequestMapping("/showCreate")
    public String create(Model model){
    model.addAttribute("productForm", new ProductForm());
    return "/create";
}

@RequestMapping("/save")
    public String save(ProductForm productForm){
    String file = productForm.getImage().getOriginalFilename();
    try {
        FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + file));
    }catch (IOException e){
        e.printStackTrace();
    }
    Product product = new Product(productForm.getId(), productForm.getName(), productForm.getDescription(), file);
    productService.save(product);
    return "redirect:/products";
}

}
