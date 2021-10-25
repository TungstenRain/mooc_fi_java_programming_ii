
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    
    /**
     * Get a List of Books from a file
     * @param file String: the filename
     * @return List<Book>: the List of Books
     */
    public static List<Book> readBooks(String file) {
        // Instantiate the List<Book>
        List<Book> listOfBooks = new ArrayList<>();
        
        // Attempt to get the Books from the file
        try {
            Files.lines(Paths.get(file))
                    // Split the row on the comma
                    .map(row -> row.split(","))
                    // Delete the rows that have less than 4 parts
                    .filter(parts -> parts.length >= 4)
                    // Instantiate a new Book from the parts split in the row
                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
                    // Add each book to the List
                    .forEach(book -> listOfBooks.add(book));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listOfBooks;
    }
}
