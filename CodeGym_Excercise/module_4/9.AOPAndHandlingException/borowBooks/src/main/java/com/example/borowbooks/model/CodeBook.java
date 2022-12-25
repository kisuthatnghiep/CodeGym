package com.example.borowbooks.model;

import javax.persistence.*;

@Entity
public class CodeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public CodeBook(Long id, String code, Book book) {
        this.id = id;
        this.code = code;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
