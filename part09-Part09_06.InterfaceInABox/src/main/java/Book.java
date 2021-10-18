/**
 * Book Class for Part09_06
 * @author frank
 */
public class Book implements Packable {
    // Variables
    private String name;
    private String author;
    private double weight;
    
    // Constructors
    /**
     * Construct the Book
     * @param author String: the Book's author
     * @param name String: the Book name
     * @param weight double: the Book weight
     */
    public Book(String author, String name, double weight) {
        this.author = author;
        this.name = name;
        this.weight = weight;
    }
    
    
    // Methods
    @Override
    /**
     * Return the weight of the Book
     * @return double: the Book weight
     */
    public double weight() {
        return this.weight;
    }
    
    @Override
    /**
     * Return a String in the following format:
     * [author]: name
     */
    public String toString() {
        return this.author + ": " + this.name;
    }
}
