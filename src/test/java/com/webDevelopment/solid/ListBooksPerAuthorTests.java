package com.webDevelopment.solid;
import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.services.HTMLFormatter;
import com.webDevelopment.solid.services.LibraryDataBase;
import com.webDevelopment.solid.useCases.ListBooksPerAuthor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListBooksPerAuthorTests {

    private ListBooksPerAuthor listBooksPerAuthor;
    private LibraryDataBase repository;
    private Author author;

    @BeforeEach
    public void setUp(){
        repository = new LibraryDataBase();
        repository.populateDatabase();
        author = new Author("JK","Rowling");
    }

    @Test
    public void listBooksPerAuthorInHTML(){
        listBooksPerAuthor = new ListBooksPerAuthor(repository, new HTMLFormatter());
        String expected = "<p>ID: 2->The book title is: 'Harry Potter y las reliquias de la muerte'" +
                " written by JK Rowling<br>ID: 3->The book title is: 'Harry Potter y la cámara secreta'" +
                " written by JK Rowling<br></p>";
        assertEquals(expected, listBooksPerAuthor.execute(author));
    }
}
