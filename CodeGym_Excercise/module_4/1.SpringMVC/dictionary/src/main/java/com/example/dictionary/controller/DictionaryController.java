package com.example.dictionary.controller;

import com.example.dictionary.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService = new DictionaryService();
    @GetMapping("/dictionary1")
    public String dictionary(){
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public ModelAndView dictionary(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("dictionary");
        String word = request.getParameter("dictionary");
        String translate = dictionaryService.findValue(word);
        if (translate != null) {
            modelAndView.addObject("translate", translate);
        }else {
            modelAndView.addObject("translate", "Not found!");
        }
        return modelAndView;
    }
}
