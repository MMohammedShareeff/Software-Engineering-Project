package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return adminService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return adminService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        adminService.deleteBook(id);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return adminService.getAllBooks();
    }
}