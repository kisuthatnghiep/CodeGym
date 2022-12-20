package com.example.thuchanh.controller;

import com.example.thuchanh.model.Customer;
import com.example.thuchanh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String index(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "/index";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        customerService.remove(id);
        return "redirect:/customer";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }
    @RequestMapping("/save")
    public String save(Customer customer){
        customer.setId(CustomerService.customers.size() + 1);
        customerService.save(customer);
        return "redirect:/customer";
    }
    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/update";
    }
    @RequestMapping("/update")
    public String update(Customer customer){
        customerService.update(customer,customer.getId());
        return "redirect:/customer";
    }
    @RequestMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/detail";
    }
}
