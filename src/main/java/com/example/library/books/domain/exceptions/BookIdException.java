package com.example.library.books.domain.exceptions;

public final class BookIdException extends RuntimeException {
    private final Long id;

    public BookIdException(Long id) {
        super("The book id " + id + " is invalid.");
        this.id = id;
    }

    public BookIdException(Long id, Throwable cause) {
        super("The book id " + id + " is invalid.", cause);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}