
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        // Instantiate the Scanner and ArrayList
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        while (true) {
            System.out.println("Input the name of the book, empty stops:");
            String bookName = scanner.nextLine();
            
            if (bookName.isEmpty()) {
                break;
            }
            System.out.println("Input the age recommendation:");
            int age = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(bookName, age));
        }
        
        // Display results
        System.out.println(books.size()+ " books in total.");
        System.out.println("Books:");
        
        // Instantiate the Comparator and set the criteria
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeRecommendation)
                .thenComparing(Book::getName);
        // Sort the collection
        Collections.sort(books, comparator);
        
        // Print out each book
        books.stream()
                .forEach(book -> System.out.println(book));
    }

}
