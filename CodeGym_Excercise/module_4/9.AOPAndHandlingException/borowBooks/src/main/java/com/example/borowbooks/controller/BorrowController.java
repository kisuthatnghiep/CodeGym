package com.example.borowbooks.controller;

import com.example.borowbooks.model.CodeBook;
import com.example.borowbooks.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private IBorrowService borrowService;

    @GetMapping
    public String findAll(Pageable pageable, Model model) {
        model.addAttribute("books", borrowService.findAll(pageable));
        return "/index";
    }

    @RequestMapping("/{id}")
    public String borrow(@PathVariable Long id, Model model) {
        CodeBook codeBook = borrowService.borrow(borrowService.findById(id).get());
        if (codeBook.getBook() == null) {
            return "/404";
        }
        model.addAttribute("code", codeBook);
        return "/form";
    }

    @PostMapping
    public String returnBook(@RequestParam("code") String code, Model model) {
        CodeBook codeBook = borrowService.returnBook(code);
        if (codeBook == null) {
            return "/404";
        }
        model.addAttribute("code", codeBook);
        return "/return";
    }

    @GetMapping("return")
    public String openReturn() {
        return "/return";
    }
}
