package com.webDevelopment.solid.models;

import java.util.List;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

public class Author {

    private String name;
    private String surname;

    public Author(String name, String surname){
        try {
            validateAuthorName(name);
            validateAuthorSurName(surname);
            this.name = name;
            this.surname = surname;
        } catch (Exception e) {
            LOGGER.error("Author-constructor cause:"+e.getMessage());
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

    public String listAuthorBooks(List<Book> books){
        String message = "";
        for (Book book:books) {
            message += book.createBookHeader() + " written by " + this.toString() + "\n";
        }
        return message;
    }

    @Override
    public String toString() {
        return this.name+" "+this.surname;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Author){
            Author author = (Author) obj;
            return this.surname.equalsIgnoreCase(author.surname)
                    && this.name.equalsIgnoreCase(author.name);
        }
        return false;
    }
}
