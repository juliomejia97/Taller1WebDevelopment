package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

@Service
public interface LibraryRepository {
    public void createBook(Book book);
    public Book getCardBookFinder();
    public void createAuthor(Author author);
}
