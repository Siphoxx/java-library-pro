package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        // 1. Setup (Create a fresh library and a book)
        Library lib = new Library();
        Book testBook = new Book("Dune", "Frank Herbert", true);

        // 2. Action (Call the method we want to test)
        lib.addBook(testBook);

        // 3. Assert (Check if the size of the books list is now 1)
        assertEquals(1, lib.books.size());
    }
}