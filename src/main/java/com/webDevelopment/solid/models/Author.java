package com.webDevelopment.solid.models;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String name;
    private String surname;
    private List<Book> books;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) throws  Exception{
        checkBookIsNew(book);
        books.add(book);
    }

    private void checkBookIsNew(Book book) throws  Exception{
        if(!books.contains(book)){
            throw new Exception("Book already exists");
        }
    }
}
