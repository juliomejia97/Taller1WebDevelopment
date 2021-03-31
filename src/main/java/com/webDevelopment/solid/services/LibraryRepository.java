package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryRepository {
    public void createBook(Book book) throws Exception;
    public Book getCardBookFinder();
    public List<Book> listBooksByAuthor(Author author);
}
