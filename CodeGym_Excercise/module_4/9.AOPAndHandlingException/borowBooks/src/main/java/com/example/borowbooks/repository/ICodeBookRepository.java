package com.example.borowbooks.repository;

import com.example.borowbooks.model.CodeBook;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICodeBookRepository extends PagingAndSortingRepository<CodeBook, Long> {
    CodeBook findCodeBookByCode(String code);
}
