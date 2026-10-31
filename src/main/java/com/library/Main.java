package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library myLibrary = new Library();

        // Load data immediately when the app starts
        myLibrary.loadFromFile();

        boolean running = true;

        System.out.println("Welcome to the Library Manager");

        while(running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clears the buffer after nextInt()

            if(choice == 1){
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();

                System.out.print("Enter Book Author: ");
                String author = scanner.nextLine();

                System.out.print("Is the book available? (true/false): ");
                boolean isavailable = scanner.nextBoolean();
                scanner.nextLine(); // CLEARS THE BUFFER AFTER nextBoolean()!

                Book myBook = new Book(title, author, isavailable);
                myLibrary.addBook(myBook);
                myLibrary.displayAllBooks();

            }
            else if (choice == 2) {
                myLibrary.displayAllBooks();
            }
            else if (choice == 3) {
                // Save data right before exiting
                myLibrary.saveToFile();
                System.out.println("GoodBye!!");
                running = false;
            }
            else {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}