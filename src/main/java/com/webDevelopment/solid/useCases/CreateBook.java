package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.Formatter;
import com.webDevelopment.solid.services.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@Service
public class CreateBook {
    private LibraryRepository repository;
    Formatter formatter;

    @Autowired
    public CreateBook(Formatter formatter, LibraryRepository repository){
        this.formatter = formatter;
        this.repository = repository;
    }

    public String execute(Book book) {
        try {
            book = repository.createBook(book);
            return formatter.Format("Book has been created with the following information\n" + book.toString());
        } catch (Exception e) {
            LOGGER.error("execute-CreateBook cause: "+e.getMessage());
            return e.getMessage();
        }
    }
}
