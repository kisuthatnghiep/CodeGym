package com.example.registrationform.controller;

import com.example.registrationform.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String openForm(Model model){
        model.addAttribute("user", new User());
        return "/form";
    }
    @PostMapping("/validate")
    public String validate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/form";
        }else {
            return "/success";
        }
    }
}
