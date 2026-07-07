package com.example.library.books.arquitecture.service;

import com.example.library.books.domain.dto.BookSortEnumDto;
import com.example.library.books.domain.dto.BookDto;
import com.example.library.books.domain.model.Book;
import com.example.library.books.domain.mappers.BookMapper;
import com.example.library.books.arquitecture.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto addBook(BookDto bookDto) {
        Book book = BookMapper.toBook(bookDto);
        book = this.bookRepository.insert(book);
        return BookMapper.toBookDto(book);
    }

    public void updateBook(BookDto bookDto){
        Book book = BookMapper.toBook(bookDto);
        this.bookRepository.update(book);
    }

    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    public List<BookDto> searchBooks(String author, Boolean available, Double maxPrice) {
        List<Book> books = this.bookRepository.findByFilters(author, available, maxPrice);
        return BookMapper.toBooksDto(books);
    }

    public BookDto getBookById(Long id) {
        return BookMapper.toBookDto(this.bookRepository.findById(id));
    }

    public List<BookDto> getAllBooks(BookSortEnumDto sort, Long page, Long limit) {
        List<Book> books = this.bookRepository.findAll(sort, page, limit);
        return BookMapper.toBooksDto(books);
    }

    public void changeBookAvailabilityById(Long id, Boolean availability) {
        Book book = this.bookRepository.findById(id);
        book.setAvailable(availability);
        this.bookRepository.update(book);
    }
}