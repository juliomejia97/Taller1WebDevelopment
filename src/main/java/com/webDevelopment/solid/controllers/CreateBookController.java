package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.CreateBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateBookController {

    private CreateBook createBook;

    @Autowired
    public CreateBookController(CreateBook createBook) {
        this.createBook = createBook;
    }

    @ExceptionHandler(NullPointerException.class)
    public String error(NullPointerException ex){
        return ex.getMessage();
    }

    @RequestMapping("/healthCheck")
    public String healthCkeck() {
        return "Server up";
    }


    @PostMapping(value="/book")
    public String createBook(@RequestBody Book book) {
        return createBook.execute(book);
    }
}

