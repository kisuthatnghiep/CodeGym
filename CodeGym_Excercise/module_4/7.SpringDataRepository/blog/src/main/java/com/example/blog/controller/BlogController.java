package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String index(Model model, Pageable pageable) {
        model.addAttribute("blogs", blogService.findAll(pageable));
        return "/index";
    }

    @GetMapping("/save")
    public String openSaveForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/save";
    }

    @GetMapping("/save/{id}")
    public String openSaveForm(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/save";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blog.setDate(LocalDate.now());
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id).get());
        return "/detail";
    }
}
