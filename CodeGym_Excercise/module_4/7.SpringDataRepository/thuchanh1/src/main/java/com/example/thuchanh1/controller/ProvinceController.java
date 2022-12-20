package com.example.thuchanh1.controller;

import com.example.thuchanh1.model.Province;
import com.example.thuchanh1.repository.IProvinceRepository;
import com.example.thuchanh1.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @RequestMapping
    public String index(Model model){
        model.addAttribute("provinces", provinceService.findAll());
        return "/ProvinceList";
    }
    @GetMapping("/save")
    public String openCreateForm(Model model){
        model.addAttribute("province", new Province());
        return "/createProvince";
    }
    @PostMapping("/save")
    public String save(Province province){
        provinceService.save(province);
        return "redirect:/province";
    }
    @GetMapping("/save/{id}")
    public String save(@PathVariable Long id, Model model){
        model.addAttribute("province", provinceService.findById(id));
        return "/createProvince";
    }
}
