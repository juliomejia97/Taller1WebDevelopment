package com.webDevelopment.solid;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.HTMLFormatter;
import com.webDevelopment.solid.services.JsonFormatter;
import com.webDevelopment.solid.services.LibraryDataBase;
import com.webDevelopment.solid.services.XMLFormatter;
import com.webDevelopment.solid.useCases.CreateBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Warning: Running all test at the same time fails due to the IDs not resetting
//Running each test individually works fine
public class CreateBookTests {

    private CreateBook createBook;
    private Book book;

    @BeforeEach
    public void setUp(){
        try {
            book = new Book("Test book", "This is the description of the test book",
                    new Author("testName", "testSurname")
                    , 2000,35000d,100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createBookInHTMLTest(){
        createBook = new CreateBook(new HTMLFormatter(), new LibraryDataBase());
        String expected = "<p>Book has been created with the following information<br>" +
                "ID=1<br>title='Test book'<br>description='This is the description of the test book" +
                "'<br>author=testName testSurname" +
                "<br>publishedYear=2000<br>price=35000.0<br>pages=100</p>";
        assertEquals(expected, createBook.execute(book));
    }

    @Test
    public void createBookInJsonTest(){
        createBook = new CreateBook(new JsonFormatter(), new LibraryDataBase());
        String expected = "{\"message\": \"Book has been created with the following information\n" +
                "ID=1\ntitle='Test book'\ndescription='This is the description of the test book" +
                "'\nauthor=testName testSurname" +
                "\npublishedYear=2000\nprice=35000.0\npages=100\"}";
        assertEquals( expected, createBook.execute(book));
    }

    @Test
    public void createBookInXMLTest(){
        createBook = new CreateBook(new XMLFormatter(), new LibraryDataBase());
        String expected = "<element att='message'>Book has been created with the following information\n" +
                "ID=1\ntitle='Test book'\ndescription='This is the description of the test book" +
                "'\nauthor=testName testSurname" +
                "\npublishedYear=2000\nprice=35000.0\npages=100</element>";
        assertEquals( expected, createBook.execute(book));
    }
}
