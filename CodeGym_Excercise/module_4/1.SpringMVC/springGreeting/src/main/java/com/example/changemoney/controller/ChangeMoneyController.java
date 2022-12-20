package com.example.changemoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChangeMoneyController {
    @GetMapping ("/changeMoney")
    public String changeMoney(){
        return "changeMoney";
    }

    @PostMapping("/change")
    public ModelAndView change(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("changeMoney");
        Long money = Long.parseLong(request.getParameter("money"))*23000;
        modelAndView.addObject("money", money);
        return modelAndView;
    }

}
