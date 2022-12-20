package com.example.productcategory.controller;

import com.example.productcategory.model.Product;
import com.example.productcategory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping
    public String display(Model model){
        model.addAttribute("products", productService.findAll());
        return "/list";
    }

    @RequestMapping("/create")
    public String goSave(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", productService.findAllCategories());
        return "/create";
    }

    @RequestMapping("/update/{id}")
    public String goSave(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", productService.findAllCategories());
        return "/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("category_id") int id, Product product){
        product.setCategory(productService.findCategoryById(id));
        productService.save(product);
        return "redirect:/product";
    }

    @RequestMapping("/remove/{id}")
    public String delete(@PathVariable Long id){
        productService.remove(id);
        return "redirect:/product";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String search){
        return new ModelAndView("/list","products",productService.search(search));
    }
}
