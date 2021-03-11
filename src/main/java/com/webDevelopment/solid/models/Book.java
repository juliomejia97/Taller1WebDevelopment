package com.webDevelopment.solid.models;

public class Book {
    private String title;
    private Author author;
    private Integer publishedYear;
    private Double price;
    private int pages;

    public Book(String title, Author author, Integer publishedYear, Double price) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public String createBookCard()
    {
        return "The book " + this.title + " has benn written by " + this.author + " and was " +
                "published in " + this.publishedYear + ". The book's price is " + this.price +
                ", and the number of pages is " + this.pages;
    }
}
