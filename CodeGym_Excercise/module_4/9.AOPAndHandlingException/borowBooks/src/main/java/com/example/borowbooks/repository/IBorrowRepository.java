package com.example.borowbooks.repository;

import com.example.borowbooks.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends PagingAndSortingRepository<Book, Long> {
}
