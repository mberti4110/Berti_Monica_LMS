// Monica Berti
// CEN 3024C
// September 7, 2024
// LMS Program
// This program will be a console-based application for managing a library's collections of books.
// It will provide a menu option for users to view, add, and remove books. It will also allow users
// to add books from a file.

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// File Manager Class
public class FileManager {
    // Method to read books from a file and add to library.
    public static List<Book> readBooks(String filePath, Library library) {
        // Create empty list to store books
        List<Book> books = new ArrayList<>();
        // Read file line by line
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                // split data in file by commas
                String[] data = scanner.nextLine().split(",");
                try {
                    int id = Integer.parseInt(data[0].trim());
                    String title = data[1].trim();
                    String author = data[2].trim();
                    // check if book id already exists in library before adding
                    if (!library.isDuplicateId(id)) {
                        books.add(new Book(id, title, author));
                    } else {
                        System.out.println("Duplicate book ID found in file: " + id + ". This entry will not be added.");
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error processing line in file: " + e.getMessage() + ". Ensure the format is correct: ID, Title, Author.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Return list of books read from file
        return books;
    }
}
