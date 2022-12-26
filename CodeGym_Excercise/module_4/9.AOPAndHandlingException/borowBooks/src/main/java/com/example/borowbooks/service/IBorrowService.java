package com.example.borowbooks.service;

import com.example.borowbooks.model.Book;
import com.example.borowbooks.model.CodeBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBorrowService {
    Page<Book> findAll(Pageable pageable);

    Optional<Book> findById(Long id);

    void delete(Long id);

    void save(Book book);

    CodeBook borrow(Book book);

    CodeBook returnBook(String code);
}
