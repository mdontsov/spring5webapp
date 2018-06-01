package com.example.spring5webapp.controller;

import com.example.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") //associated URL view
    public String getBooks(Model model) {
        model. addAttribute("books", bookRepository.findAll());
        return "books"; //Return 'books' thymeleaf template
    }
}