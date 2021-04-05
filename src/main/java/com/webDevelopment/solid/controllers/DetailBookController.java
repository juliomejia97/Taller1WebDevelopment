package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.DetailBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailBookController {

    private DetailBook detailBook;

    @Autowired
    public DetailBookController(DetailBook detailBook){
        this.detailBook = detailBook;
    }
    @GetMapping(value="/book/{id}")
    public String detailBook(@PathVariable int id) {
        return detailBook.execute(id);
    }

}
