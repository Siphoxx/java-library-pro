package com.library;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Success! Book added. ");
    }

    public void displayAllBooks() {
        System.out.println("----Library Catalogue-----");
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        for (Book b : books) {
            b.displayInfo();
            System.out.println("--------------------------");
        }
    }

    // SAVE TO FILE
    public void saveToFile() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Book book : books) {
                sb.append(book.title).append(",")
                        .append(book.author).append(",")
                        .append(book.bookAvailability).append("\n");
            }
            Files.writeString(Path.of("library.txt"), sb.toString());
            System.out.println("Library saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    // LOAD FROM FILE
    public void loadFromFile() {
        try {
            Path path = Path.of("library.txt");
            if (!Files.exists(path)) {
                return; // If the file doesn't exist yet, just exit quietly.
            }

            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    boolean isAvailable = Boolean.parseBoolean(parts[2]);

                    Book book = new Book(title, author, isAvailable);
                    books.add(book);
                }
            }
            System.out.println("Library loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading from file.");
        }
    }
}