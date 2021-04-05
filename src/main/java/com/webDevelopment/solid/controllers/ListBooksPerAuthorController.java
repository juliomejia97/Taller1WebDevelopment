package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.useCases.ListBooksPerAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListBooksPerAuthorController {
    private ListBooksPerAuthor listBooksPerAuthor;
    @Autowired
    public ListBooksPerAuthorController(ListBooksPerAuthor listBooksPerAuthor){
        this.listBooksPerAuthor = listBooksPerAuthor;
    }

    @ExceptionHandler(NullPointerException.class)
    public String error(NullPointerException ex){
        return ex.getMessage();
    }

    @GetMapping(value="/book/author")
    public String listBooksOfAuthor(@RequestBody Author author){
        return listBooksPerAuthor.execute(author);
    }
}
