package com.example.borowbooks.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CodeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private LocalDate dateBorrow;
    private LocalDate dateReturn;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public CodeBook(Long id, String code, LocalDate dateBorrow, LocalDate dateReturn, Book book) {
        this.id = id;
        this.code = code;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.book = book;
    }

    public CodeBook(LocalDate dateBorrow, String code, Book book) {
        this.code = code;
        this.dateBorrow = dateBorrow;
        this.book = book;
    }

    public CodeBook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDate dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
