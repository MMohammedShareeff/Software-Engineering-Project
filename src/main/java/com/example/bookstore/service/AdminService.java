package com.example.bookstore.service;

import com.example.bookstore.config.BookValidator;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        if (BookValidator.getInstance().validate(book)) {
            return bookRepository.save(book);
        }
        throw new IllegalArgumentException("Invalid book data");
    }

    public Book updateBook(Long id, Book book) {
        Book existing = bookRepository.findById(id).orElseThrow();
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPrice(book.getPrice());
        existing.setQuantity(book.getQuantity());
        return bookRepository.save(existing);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}