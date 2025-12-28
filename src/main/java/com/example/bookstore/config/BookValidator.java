package com.example.bookstore.config;

import com.example.bookstore.entity.Book;

public class BookValidator {
    private static BookValidator instance;

    private BookValidator() {}  // Private constructor for Singleton

    public static BookValidator getInstance() {
        if (instance == null) {
            instance = new BookValidator();
        }
        return instance;
    }

    public boolean validate(Book book) {
        return book.getTitle() != null && !book.getTitle().isEmpty() &&
                book.getAuthor() != null && !book.getAuthor().isEmpty() &&
                book.getPrice() > 0 && book.getQuantity() >= 0;
    }
}