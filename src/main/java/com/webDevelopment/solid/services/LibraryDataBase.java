package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryDataBase implements LibraryRepository {
    List<Book> books;

    public LibraryDataBase(){
        this.books = new ArrayList<>();
    }

    @Override
    public void createBook(Book book) throws Exception{
        if(books.contains(book)){
            throw new Exception("The book already exists");
        }
        books.add(book);
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
    public Book findBook(Book bookIdentifier) throws Exception {
        Book bookFound = null;
        for(Book book: books){
            bookFound = (book.equals(bookIdentifier))? book:null;
        }
        if(bookFound == null){
            throw new Exception("The book does not exist");
        }
        return bookFound;
    }
}
