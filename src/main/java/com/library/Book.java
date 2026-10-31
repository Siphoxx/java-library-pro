package com.library;

public class Book {
    String title;
    String author;
    boolean bookAvailability;

    public Book(String bookTitle, String bookAuthor, boolean bookAvailability) {
        title = bookTitle;
        author = bookAuthor;
        this.bookAvailability = bookAvailability;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availablity: " + bookAvailability);
    }
}