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
