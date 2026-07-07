package com.example.library.books.domain.exceptions;

public final class BookSearchException extends RuntimeException {
    private final String author;
    private final Double maxPrice;
    private final Boolean availability;

    public BookSearchException(String author, Double maxPrice, Boolean availability) {
        super("The book search with Author: " + author +
                " MaxPrice: " + maxPrice +
                " Availability: " + availability +
                " is invalid.");
        this.author = author;
        this.maxPrice = maxPrice;
        this.availability = availability;
    }

    public BookSearchException(String author, Double maxPrice, Boolean availability, Throwable cause) {
        super("The book search with Author: " + author +
                " MaxPrice: " + maxPrice +
                " Availability: " + availability +
                " is invalid.", cause);
        this.author = author;
        this.maxPrice = maxPrice;
        this.availability = availability;
    }

    public String getAuthor() {
        return author;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public Boolean getAvailability() {
        return availability;
    }
}
