package com.example.customermanager.controller;

import com.example.customermanager.model.Customer;
import com.example.customermanager.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @RequestMapping
    public String index(Model model){
        model.addAttribute("customer", customerService.findAll());
        return "/index";
    }
    @RequestMapping("save")
    public String index(Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }
    @RequestMapping("update/{id}")
    public ModelAndView create(@PathVariable Long id){
        return new ModelAndView("/create","customer",customerService.findOne(id));
    }
}
