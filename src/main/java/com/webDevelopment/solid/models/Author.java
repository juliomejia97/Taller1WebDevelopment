package com.webDevelopment.solid.models;
import java.util.ArrayList;
import java.util.List;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

public class Author {

    private String name;
    private String surname;
    private List<Book> books;
    public Author(String name, String surname){
        try {
            validateAuthorName(name);
            validateAuthorSurName(surname);
            this.name = name;
            this.surname = surname;
            this.books = new ArrayList<>();
        } catch (Exception e) {
            LOGGER.error("Author-constructor cause:"+e.getMessage());
        }
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
    private void validateAuthorName(String name) throws  Exception{
        if(name.isEmpty()){
            throw new Exception("The author must have a name");
        }
    }
    private void validateAuthorSurName(String surname) throws  Exception{
        if(surname.isEmpty()){
            throw new Exception("The author must have a surname");
        }
    }
    public void validateAuthor() throws Exception{
        validateAuthorName(this.name);
        validateAuthorSurName(this.surname);
    }
    @Override
    public String toString() {
        return this.name+" "+this.surname;
    }
}
