package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/create");
        if (customer.getId() == null) {
            modelAndView.addObject("message", "New customer created successfully");
        }else {
            modelAndView.addObject("message", "Change information successfully");
        }
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listCustomers() {
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        customerService.remove(id);
        return "redirect:/customer";
    }
    @RequestMapping("/update/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/create";
    }
}
