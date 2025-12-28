package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/books")
    public List<Book> getAvailableBooks() {
        return customerService.getAvailableBooks();
    }

    @GetMapping("/books/search/title")
    public List<Book> searchByTitle(@RequestParam String title) {
        return customerService.searchByTitle(title);
    }

    @GetMapping("/books/search/author")
    public List<Book> searchByAuthor(@RequestParam String author) {
        return customerService.searchByAuthor(author);
    }
}