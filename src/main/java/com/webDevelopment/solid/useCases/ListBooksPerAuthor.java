package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListBooksPerAuthor {
    private LibraryRepository repository;

    @Autowired
    public ListBooksPerAuthor(LibraryRepository repository){
        this.repository = repository;
    }

    public String execute(Author author){
        List<Book> booksOfAuthor = repository.listBooksByAuthor(author);
        return (!booksOfAuthor.isEmpty()) ? author.listBooks(booksOfAuthor) : "The author does not have books";
    }
}
