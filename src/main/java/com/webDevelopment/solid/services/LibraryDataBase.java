package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryDataBase implements LibraryRepository {
    List<Book> books;
    List<Author> authors;

    public LibraryDataBase(){
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
    }
    @Override
    public void createBook(Book book) {

    }

    @Override
    public Book getCardBookFinder() {
        return null;
    }

    @Override
    public void createAuthor(Author author) {

    }
}
