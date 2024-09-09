// Monica Berti
// CEN 3024C
// September 7, 2024
// LMS Program
// This program will be a console-based application for managing a library's collections of books.
// It will provide a menu option for users to view, add, and remove books. It will also allow users
// to add books from a file.

import java.util.HashMap;
import java.util.Map;

// Library Class
public class Library {
    // Create HashMap to store books, using their ID as the key
    private Map<Integer, Book> books = new HashMap<>();

    // Method to add books
    public void addBook(Book book) {
        // Error handling for duplicate book ID
        if (isDuplicateId(book.getId())){
            System.out.println("Error: A book with ID " + book.getId() + " already exists. Cannot add duplicate entries.");
        } else {
            books.put(book.getId(), book);
            System.out.println("Book added: " + book);
        }
    }

    // Method to remove books
    public void removeBook(int id) {
        if (books.remove(id) != null) {
            System.out.println("Book removed with ID: " + id);
        } else {
            System.out.println("No book found with ID: " + id);
        }
    }

    // Method to List books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Listing all books:");
            books.values().forEach(System.out::println);
        }
    }

    //Method to check if duplicate ID
    public boolean isDuplicateId(int id) {
        return books.containsKey(id);
    }
}
