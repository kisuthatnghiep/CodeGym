package com.example.song.controller;

import com.example.song.model.Category;
import com.example.song.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/categoryList";
    }

    @GetMapping("/create")
    public String openSaveForm(Model model) {
        model.addAttribute("category", new Category());
        return "/categorySave";
    }

    @GetMapping("/save/{id}")
    public String openEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/categorySave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/category";
    }
}
