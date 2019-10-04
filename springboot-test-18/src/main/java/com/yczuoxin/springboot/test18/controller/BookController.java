package com.yczuoxin.springboot.test18.controller;

import com.yczuoxin.springboot.test18.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(Book.class)
public class BookController {

    @Autowired
    private Book book;

    @GetMapping("/book")
    public Book getBook() {
        return book;
    }

}
