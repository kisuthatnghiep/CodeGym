package com.example.customermanager.controller;

import com.example.customermanager.model.Customer;
import com.example.customermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ModelAndView displayCustomer(){
        ModelAndView modelAndView = new ModelAndView("customerList");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }
}
