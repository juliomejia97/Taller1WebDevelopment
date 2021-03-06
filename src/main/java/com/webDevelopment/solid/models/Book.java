package com.webDevelopment.solid.models;

import java.time.LocalDate;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

public class Book {

    private static int NEXT_ID = 0;
    private int ID;
    private String title;
    private String description;
    private Author author;
    private Integer publishedYear;
    private Double price;
    private int pages;

    public Book(String title, String description, Author author, Integer publishedYear, Double price, int pages) throws Exception {
        try {
            validateTitle(title);
            validateDescription(description);
            validatePrice(price);
            author.validateAuthor();
            validatePublishedYear(publishedYear);
            validatePages(pages);
            this.title = title;
            this.description = description;
            this.author = author;
            this.publishedYear = publishedYear;
            this.price = price;
            this.pages = pages;
        } catch (Exception e) {
            LOGGER.error("Book-validateBook cause:" + e.getMessage());
            throw new NullPointerException("The book wasn't created - " + e.getMessage());
        }
    }

    private void validateTitle(String title) throws Exception {
        if (title.length() == 0) {
            throw new Exception("The Book must have a title.");
        }
    }

    private void validateDescription(String description) throws Exception {
        if (description.length() > 200) {
            throw new Exception("The description must have less than 200 characters.");
        }
    }

    private void validatePrice(Double price) throws Exception {
        double decimals = price - price.intValue();
        if (price < 10000 || decimals > 0) {
            throw new Exception("The price of the book should be an integer greater than 10000.");
        }
    }

    private void validatePublishedYear(Integer publishedYear) throws Exception {
        if (LocalDate.now().getYear() < publishedYear) {
            throw new Exception("The year of publication must be less or equal than the current year.");
        }
        if ( publishedYear.toString().length() != 4){
            throw new Exception("The year of publication must have exactly 4 digits");
        }
    }

    private void validatePages(int pages) throws Exception {
        if (pages < 0 || pages > 1500) {
            throw new Exception("The number of pages must be a positive number and less than 1500 pages.");
        }
    }

    public boolean sameId(int id) {
        return this.ID == id;
    }

    public boolean sameAuthor(Author author) {
        return this.author.equals(author);
    }

    public void assignId() {
        this.ID = Book.NEXT_ID + 1;
        Book.NEXT_ID++;
    }

    public String createBookHeader() {
        return "ID: " + this.ID + "->The book title is: '" + this.title + "'";
    }

    public String createBookDetail() {
        return "The book '" + this.title + "' has been written by " + this.author + " and was " +
                "published in " + this.publishedYear + ". The book's price is " + this.price +
                ", and the number of pages is " + this.pages + ". A short description is '" + this.description + "'.";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.title.equalsIgnoreCase(book.title) && this.author.equals(book.author);
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID=" + ID +
                "\ntitle='" + title + '\'' +
                "\ndescription='" + description + '\'' +
                "\nauthor=" + author +
                "\npublishedYear=" + publishedYear +
                "\nprice=" + price +
                "\npages=" + pages;
    }
}
