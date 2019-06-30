package com.yczuoxin.springboot.test9.controller;

import com.yczuoxin.springboot.test9.domain.Book;
import com.yczuoxin.springboot.test9.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/book")
    public Book save(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    @GetMapping("/book/{id}")
    public Book findById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
