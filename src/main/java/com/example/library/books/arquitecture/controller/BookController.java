package com.example.library.books.arquitecture.controller;

import com.example.library.books.domain.dto.BookSortEnumDto;
import com.example.library.books.domain.dto.BookDto;
import com.example.library.books.arquitecture.service.BookService;
import com.example.library.books.domain.exceptions.BookIdException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/books", consumes="application/json", produces="application/json")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDtoIn) {
        BookDto bookDtoOut = this.bookService.addBook(bookDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDtoOut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBookById(@PathVariable Long id, @Valid @RequestBody BookDto bookDto) {
        if (!id.equals(bookDto.getId())) {
            throw new BookIdException(id);
        }
        this.bookService.updateBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBookById(@PathVariable Long id) {
        this.bookService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> searchBooks(
            @RequestParam(required=false) String author,
            @RequestParam(required=false) Boolean available,
            @RequestParam(required=false) Double maxPrice) {

        List<BookDto> booksDto = this.bookService.searchBooks(author, available, maxPrice);
        return ResponseEntity.status(HttpStatus.OK).body(booksDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        BookDto bookDto = this.bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(
            @RequestParam(required=false) BookSortEnumDto sort,
            @RequestParam(required=false) Long page,
            @RequestParam(required=false) Long limit) {

        List<BookDto> booksDto = this.bookService.getAllBooks(sort, page, limit);
        return ResponseEntity.status(HttpStatus.OK).body(booksDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> changeAvailabilityById(@PathVariable Long id, @RequestParam Boolean availability) {
        this.bookService.changeBookAvailabilityById(id, availability);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}