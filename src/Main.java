// Monica Berti
// CEN 3024C
// September 7, 2024
// LMS Program
// This program will be a console-based application for managing a library's collections of books.
// It will provide a menu option for users to view, add, and remove books. It will also allow users
// to add books from a file.

// Main Class
public class Main {
    public static void main(String[] args) {
        // Instantiate Library Class to hold collection of books
        Library library = new Library();

        // Create Menu object, and include library of books
        Menu menu = new Menu(library);

        // Loop to display menu options continuously
        while (true) {
            menu.displayMenu();
            menu.selectOption();
        }
    }
}
