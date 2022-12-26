package com.example.borowbooks.service;

import com.example.borowbooks.model.Book;
import com.example.borowbooks.model.CodeBook;
import com.example.borowbooks.repository.IBorrowRepository;
import com.example.borowbooks.repository.ICodeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;

    @Autowired
    private ICodeBookRepository codeBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return borrowRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return borrowRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        borrowRepository.deleteById(id);
    }

    @Override
    public void save(Book book) {
        borrowRepository.save(book);
    }

    @Override
    public CodeBook borrow(Book book) {
        if (book.getQuantity() <= 0) {
            return new CodeBook();
        }
        CodeBook codeBook = new CodeBook(LocalDate.now(), randomCode(), book);
        codeBookRepository.save(codeBook);
        book.setQuantity(book.getQuantity() - 1);
        save(book);
        return codeBook;
    }

    @Override
    public CodeBook returnBook(String codeBook) {
        CodeBook code = codeBookRepository.findCodeBookByCode(codeBook);
        if (code != null) {
            if (code.getDateReturn() != null) {
                return null;
            }
            code.setDateReturn(LocalDate.now());
            codeBookRepository.save(code);
            code.getBook().setQuantity(code.getBook().getQuantity() + 1);
            save(code.getBook());
            return code;
        }
        return null;
    }

    private String randomCode() {
        double a = Math.random() * 100000;
        return String.valueOf((int) a);
    }
}
