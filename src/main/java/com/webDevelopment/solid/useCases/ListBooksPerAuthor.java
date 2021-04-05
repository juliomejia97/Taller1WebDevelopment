package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Author;
import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.Formatter;
import com.webDevelopment.solid.services.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListBooksPerAuthor {
    private LibraryRepository repository;
    private Formatter formatter;

    @Autowired
    public ListBooksPerAuthor(LibraryRepository repository, Formatter formatter){
        this.formatter = formatter;
        this.repository = repository;
    }

    public String execute(Author author){
        List<Book> booksOfAuthor = repository.listBooksByAuthor(author);
        if(!booksOfAuthor.isEmpty()){
            return formatter.Format(author.listAuthorBooks(booksOfAuthor));
        }
        return "The author does not have books";
    }
}
