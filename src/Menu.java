// Monica Berti
// CEN 3024C
// September 7, 2024
// LMS Program
// This program will be a console-based application for managing a library's collections of books.
// It will provide a menu option for users to view, add, and remove books. It will also allow users
// to add books from a file.

import java.util.Scanner;
import java.util.List;

// Menu Class
public class Menu {
    // Create Library Instance
    private Library library;

    // Create scanner
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public Menu(Library library) {
        this.library = library;
    }

    // Method to display menu
    public void displayMenu() {
        System.out.println("\n1. Add Books from File");
        System.out.println("2. Add Books Manually");
        System.out.println("3. Remove Book");
        System.out.println("4. List All Books");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    // Method to select menu option
    public void selectOption() {
        // Read user menu selection
        int choice = scanner.nextInt();
        // Clear the buffer to properly read the next line of text
        scanner.nextLine();

        // Menu selection
        switch (choice) {
            // Option 1: Add books from file
            case 1:
                System.out.print("Enter the location of the book data file: ");
                String filePath = scanner.nextLine();
                List<Book> books = FileManager.readBooks(filePath, library); // Pass library here
                books.forEach(library::addBook);
                break;
            // Option 2: Add books manually
            case 2:
                System.out.print("Enter ID, Title, Author (comma-separated): ");
                String[] bookData = scanner.nextLine().split(",");
                try {
                    int id = Integer.parseInt(bookData[0]);
                    String title = bookData[1];
                    String author = bookData[2];
                    library.addBook(new Book(id, title, author));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid format for book details. Please use the format ID,Title,Author.");
                }
                break;
            // Option 3: Remove book from file
            case 3:
                System.out.print("Enter Book ID to remove: ");
                int removeId = Integer.parseInt(scanner.nextLine());
                library.removeBook(removeId);
                break;
            // Option 4: List Books in Library
            case 4:
                library.listBooks();
                break;
            // Option 5: Exit Program
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }
}
