package com.webDevelopment.solid;
import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.services.HTMLFormatter;
import com.webDevelopment.solid.services.JsonFormatter;
import com.webDevelopment.solid.services.LibraryDataBase;
import com.webDevelopment.solid.services.XMLFormatter;
import com.webDevelopment.solid.useCases.ListBooksPerAuthor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Warning: Running all test at the same time fails due to the IDs not resetting
//Running each test individually works fine
public class ListBooksPerAuthorTests {

    private ListBooksPerAuthor listBooksPerAuthor;
    private LibraryDataBase repository;
    private Author author;

    @BeforeEach
    public void setUp(){
        repository = new LibraryDataBase();
        repository.populateDatabase();
        try {
            author = new Author("JK","Rowling");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listBooksPerAuthorInHTML(){
        listBooksPerAuthor = new ListBooksPerAuthor(repository, new HTMLFormatter());
        String expected = "<p>ID: 2->The book title is: 'Harry Potter y las reliquias de la muerte'" +
                " written by JK Rowling<br>ID: 3->The book title is: 'Harry Potter y la cámara secreta'" +
                " written by JK Rowling<br></p>";
        assertEquals(expected, listBooksPerAuthor.execute(author));
    }

    @Test
    public void listBooksPerAuthorInJson(){
        listBooksPerAuthor = new ListBooksPerAuthor(repository, new JsonFormatter());
        String expected = "{\"message\": \"ID: 2->The book title is: 'Harry Potter y las reliquias de la muerte'" +
                " written by JK Rowling\nID: 3->The book title is: 'Harry Potter y la cámara secreta'" +
                " written by JK Rowling\n\"}";
        assertEquals(expected, listBooksPerAuthor.execute(author));
    }

    @Test
    public void listBooksPerAuthorInXML(){
        listBooksPerAuthor = new ListBooksPerAuthor(repository, new XMLFormatter());
        String expected = "<element att='message'>ID: 2->The book title is: 'Harry Potter y las reliquias de la muerte'" +
                " written by JK Rowling\nID: 3->The book title is: 'Harry Potter y la cámara secreta'" +
                " written by JK Rowling\n</element>";
        assertEquals(expected, listBooksPerAuthor.execute(author));
    }
}
