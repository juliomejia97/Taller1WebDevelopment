package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@Service
public class LibraryDataBase implements LibraryRepository {
    List<Book> books;

    public LibraryDataBase(){
        this.books = new ArrayList<>();
        //populateDatabase();
    }

    public void populateDatabase(){
        try {
            createBook(new Book("Homo Deus","Retos del siglo XXI"
                    ,new Author("Yuval Noah","Harari")
                    ,2016,45000d,489));
            createBook(new Book("Harry Potter y las reliquias de la muerte","Harry, Ron y Hermione se marchan de Hogwarts para iniciar su misión más importante: tienen que destruir los horrocruxes, el secreto del poder y la inmortalidad de Voldemort."
                    ,new Author("JK","Rowling")
                    ,2007,61000d,758));
            createBook(new Book("Harry Potter y la cámara secreta","Harry Potter y los estudiantes de segundo año investigan una malévola amenaza para sus compañeros de clases de Hogwarts."
                    ,new Author("JK","Rowling")
                    ,1999,37800d,341));
        } catch (Exception e) {
            LOGGER.error("execute-CreateBook cause: "+e.getMessage());
        }
    }

    @Override
    public Book createBook(Book book) throws Exception{
        if(books.contains(book)){
            throw new Exception("The book already exists");
        }
        book.assignId();
        books.add(book);
        return book;
    }

    @Override
    public List<Book> listBooksByAuthor(Author author) {
        List<Book> booksOfAuthor = new ArrayList<>();
        for (Book book:books) {
            if(book.sameAuthor(author)){
                booksOfAuthor.add(book);
            }
        }
        return booksOfAuthor;
    }

    @Override
    public Book findBookById(int id) throws Exception {
        for(Book book: books){
            if(book.sameId(id)){
                return book;
            }
        }
        throw new Exception("The book does not exist");
    }
}
