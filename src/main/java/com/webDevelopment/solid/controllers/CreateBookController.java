package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.CreateBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBookController {

    private CreateBook createBook;

    @Autowired
    public CreateBookController(CreateBook createBook) {
        this.createBook = createBook;
    }

    @RequestMapping("/healthCheck")
    public String healthCkeck() {
        return "Server up";
    }


    @PostMapping(value="/book/create")
    public String findBookCard(@RequestBody Book book) {
        return createBook.execute(book);
    }
}
