package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryRepository {
    Book createBook(Book book) throws Exception;
    Book findBookById(int id) throws Exception;
    List<Book> listBooksByAuthor(Author author);
}
