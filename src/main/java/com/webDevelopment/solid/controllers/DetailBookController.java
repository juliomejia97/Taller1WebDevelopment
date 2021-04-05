package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.DetailBook;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailBookController {

    private DetailBook detailBook;

    @GetMapping(value="/book/detail")
    public String detailBook(@RequestBody Book book) {
        return detailBook.execute(book);
    }

}
