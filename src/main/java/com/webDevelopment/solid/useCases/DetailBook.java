package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.LibraryRepository;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

public class DetailBook {

    private LibraryRepository repository;

    public String execute(Book book){
        try {
            Book bookFound = repository.findBook(book);
            return bookFound.createBookDetail();
        } catch (Exception e) {
            LOGGER.error("execute-CreateBook cause:"+e.getMessage());
            return e.getMessage();
        }
    }
}
