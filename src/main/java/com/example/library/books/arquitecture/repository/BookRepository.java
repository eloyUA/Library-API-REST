package com.example.library.books.arquitecture.repository;

import com.example.library.books.domain.model.Book;
import com.example.library.books.domain.dto.BookSortEnumDto;

import java.util.List;

public interface BookRepository {
    Book insert(Book book);
    void update(Book book);
    void deleteById(Long id);
    Book findById(Long id);
    List<Book> findByFilters(String author, Boolean available, Double maxPrice);
    List<Book> findAll(BookSortEnumDto bookSortEnum, Long page, Long limit);
}