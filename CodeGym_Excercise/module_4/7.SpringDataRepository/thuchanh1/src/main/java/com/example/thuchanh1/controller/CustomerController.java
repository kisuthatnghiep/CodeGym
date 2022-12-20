package com.example.thuchanh1.controller;

import com.example.thuchanh1.model.Customer;
import com.example.thuchanh1.model.Province;
import com.example.thuchanh1.service.ICustomerService;
import com.example.thuchanh1.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/createCustomer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping
    public String listCustomers(Model model) {
        Iterable<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "/CustomerList";
    }
    @GetMapping("/save/{id}")
    public String save(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.findById(id).get());
        return "/createCustomer";
    }
}
