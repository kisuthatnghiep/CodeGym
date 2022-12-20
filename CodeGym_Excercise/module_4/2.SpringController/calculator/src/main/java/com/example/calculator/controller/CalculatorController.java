package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CalculatorController {
    @RequestMapping
    public String display() {
        return "/calculator";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("sh1") double sh1, @RequestParam("sh2") double sh2, @RequestParam("cal") String cal, Model model) {
        switch (cal){
            case "add":
                model.addAttribute("result", sh1 + sh2);
                break;
            case "sub":
                model.addAttribute("result", sh1 - sh2);
                break;
            case "mul":
                model.addAttribute("result", sh1 * sh2);
                break;
            case "division":
                model.addAttribute("result", sh1 / sh2);
                break;
        }
        return "/calculator";
    }
}
