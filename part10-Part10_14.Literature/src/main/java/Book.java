/**
 * Book Class for Part10_14
 * @author frank
 */
public class Book implements Comparable<Book> {
    // Variables
    private String name;
    private int ageRecommendation;
    
    // Constructors
    /**
     * Construct the Book
     * @param name String: the Book name
     * @param ageRecommendation int: the youngest age recommended for the book
     */
    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }
    
    // Methods
    /**
     * Get the name
     * @return String: the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get the recommended age for the Book
     * @return int: the recommended age
     */
    public int getAgeRecommendation() {
        return this.ageRecommendation;
    }
    
    @Override
    /**
     * Returns a String in the following format:
     * [name](recommended for [age recommended] year-olds or older)
     */
    public String toString() {
        return this.name + " (recommended for " + this.ageRecommendation + " year-olds or older)";
    }

    @Override
    public int compareTo(Book compared) {
        return this.ageRecommendation - compared.ageRecommendation;
    }
}
