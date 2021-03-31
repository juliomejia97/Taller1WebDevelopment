package com.webDevelopment.solid.models;
import java.time.LocalDate;

import static com.webDevelopment.solid.SolidApplication.LOGGER;
public class Book {
    private String title;
    private String description;
    private Author author;
    private Integer publishedYear;
    private Double price;
    private int pages;

    public Book(String title, String description, Author author, Integer publishedYear, Double price, int pages) {
        try {
            validateTitle(title);
            validateDescription(description);
            validatePrice(price);
            author.validateAuthor();
            validatepublishedYear(publishedYear);
            validatePages(pages);
            this.title = title;
            this.description = description;
            this.author = author;
            this.publishedYear = publishedYear;
            this.price = price;
            this.pages = pages;
        } catch (Exception e) {
            LOGGER.error("Book-validateBook cause:"+e.getMessage());
        }
    }

    public String createBookCard()
    {
        return "The book " + this.title + " has benn written by " + this.author + " and was " +
                "published in " + this.publishedYear + ". The book's price is " + this.price +
                ", and the number of pages is " + this.pages + ". A short descrption is "+ this.description;
    }

    private void validateTitle(String title) throws Exception{
        if(title.length() == 0){
            throw new Exception("The Book must have a title.");
        }
    }

    private void validateDescription(String description) throws Exception{
        if(description.length() > 200){
            throw new Exception("The description must have less than 200 characters.");
        }
    }
    private void validatePrice(Double price) throws Exception{
        Double decimals = price - price.intValue();
        if(price < 10000 || decimals > 0){
            throw new Exception("The price of the book should be an integer greater than 10000.");
        }
    }
    private void validatepublishedYear(Integer publishedYear) throws Exception{
        if(LocalDate.now().getYear() < publishedYear){
            throw new Exception("The year of publication must be less or equal than the current year.");
        }
    }
    private void validatePages(int pages) throws Exception {
        if(pages < 0 || pages > 1500){
            throw new Exception("The number of pages must be a positive number and less than 1500 pages.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book){
            Book book = (Book) obj;
            return this.title.equalsIgnoreCase(book.title) && this.author.equals(book.author);
        }
        return false;
    }

    public boolean sameAuthor(Author author){
        return this.author.equals(author);
    }

    public String getTitle(){
        return title;
    }

}
