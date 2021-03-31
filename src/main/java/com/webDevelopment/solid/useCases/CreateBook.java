package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.webDevelopment.solid.SolidApplication.LOGGER;

@Service
public class CreateBook {

    private LibraryRepository repository;

    @Autowired
    public CreateBook(LibraryRepository repository) {
        this.repository = repository;
    }

    public String execute(Book book) {
        LOGGER.error(book.createBookCard());
        return "ERROR";
    }
}