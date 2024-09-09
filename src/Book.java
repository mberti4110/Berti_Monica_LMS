// Monica Berti
// CEN 3024C
// September 7, 2024
// LMS Program
// This program will be a console-based application for managing a library's collections of books.
// It will provide a menu option for users to view, add, and remove books. It will also allow users
// to add books from a file.

// Book Class

public class Book {
    // Create Variables
    private int id; // Unique identifier for the book
    private String title;
    private String author;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

