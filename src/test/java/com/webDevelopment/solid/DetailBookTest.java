package com.webDevelopment.solid;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.services.HTMLFormatter;
import com.webDevelopment.solid.services.JsonFormatter;
import com.webDevelopment.solid.services.LibraryDataBase;
import com.webDevelopment.solid.services.XMLFormatter;
import com.webDevelopment.solid.useCases.DetailBook;
import com.webDevelopment.solid.useCases.ListBooksPerAuthor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


//Warning: Running all test at the same time fails due to the IDs not resetting
//Running each test individually works fine
public class DetailBookTest {

    private LibraryDataBase repository;
    private DetailBook detailBook;

    @BeforeEach
    public void setUp(){
        repository = new LibraryDataBase();
        repository.populateDatabase();
    }

    @Test
    public void detailBookInHTML(){
        detailBook = new DetailBook(repository, new HTMLFormatter());
        String expected = "<p>The book 'Harry Potter y las reliquias de la muerte' " +
                "has been written by JK Rowling and was published in 2007. The book's" +
                " price is 61000.0, and the number of pages is 758. A short description" +
                " is 'Harry, Ron y Hermione se marchan de Hogwarts para iniciar su misión " +
                "más importante: tienen que destruir los horrocruxes, el secreto del poder" +
                " y la inmortalidad de Voldemort.'.</p>";
        assertEquals(expected, detailBook.execute(2));
    }

    @Test
    public void detailBookInJson(){
        detailBook = new DetailBook(repository, new JsonFormatter());
        String expected = "{\"message\": \"The book 'Harry Potter y las reliquias de la muerte' " +
                "has been written by JK Rowling and was published in 2007. The book's" +
                " price is 61000.0, and the number of pages is 758. A short description" +
                " is 'Harry, Ron y Hermione se marchan de Hogwarts para iniciar su misión " +
                "más importante: tienen que destruir los horrocruxes, el secreto del poder" +
                " y la inmortalidad de Voldemort.'.\"}";
        assertEquals(expected, detailBook.execute(2));
    }

    @Test
    public void detailBookInXML(){
            detailBook = new DetailBook(repository, new XMLFormatter());
        String expected = "<element att='message'>The book 'Harry Potter y las reliquias de la muerte' " +
                "has been written by JK Rowling and was published in 2007. The book's" +
                " price is 61000.0, and the number of pages is 758. A short description" +
                " is 'Harry, Ron y Hermione se marchan de Hogwarts para iniciar su misión " +
                "más importante: tienen que destruir los horrocruxes, el secreto del poder" +
                " y la inmortalidad de Voldemort.'.</element>";
        assertEquals(expected, detailBook.execute(2));
    }
}
