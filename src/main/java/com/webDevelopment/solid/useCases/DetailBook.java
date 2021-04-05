package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.Formatter;
import com.webDevelopment.solid.services.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Format;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@Service
public class DetailBook {

    private LibraryRepository repository;
    private Formatter formatter;

    @Autowired
    public DetailBook(LibraryRepository repository, Formatter formatter){
        this.formatter = formatter;
        this.repository = repository;
    }

    public String execute(int BookId){
        try {
            Book bookFound = repository.findBookById(BookId);
            return formatter.Format(bookFound.createBookDetail());
        } catch (Exception e) {
            LOGGER.error("execute-DetailBook cause: "+e.getMessage());
            return e.getMessage();
        }
    }
}
