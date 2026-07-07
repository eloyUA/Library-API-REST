package com.example.library.books.domain.mappers;

import com.example.library.books.domain.model.Book;
import com.example.library.books.domain.dto.BookDto;

import java.util.LinkedList;
import java.util.List;

public class BookMapper {

    public static Book toBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPages(bookDto.getPages());
        book.setPrice(bookDto.getPrice());
        book.setAvailable(bookDto.getAvailable());
        return book;
    }

    public static List<Book> toBooks(List<BookDto> booksDto) {
        List<Book> books = new LinkedList<>();
        for (BookDto bookDto : booksDto) {
            books.add(toBook(bookDto));
        }
        return books;
    }

    public static BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setPages(book.getPages());
        bookDto.setPrice(book.getPrice());
        bookDto.setAvailable(book.getAvailable());
        return bookDto;
    }

    public static List<BookDto> toBooksDto(List<Book> books) {
        List<BookDto> booksDto = new LinkedList<>();
        for (Book book : books) {
            booksDto.add(toBookDto(book));
        }
        return booksDto;
    }
}
