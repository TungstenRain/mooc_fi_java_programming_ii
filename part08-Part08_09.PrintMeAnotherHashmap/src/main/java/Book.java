
public class Book {
    // Variables
    private String name;
    private String contents;
    private int publicationYear;
    
    // Constructors
    /**
     * Construct the book
     * @param name String: the book name
     * @param publicationYear int: the year the book was published
     * @param contents String: the book contents
     */
    public Book(String name, int publicationYear, String contents) {
        this.name = name;
        this.publicationYear = publicationYear;
        this.contents = contents;
    }
    
    /**
     * Get the Book name
     * @return String: the Book name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Set the Book name
     * @param name String: the book name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the publication year
     * @return int: the publication year
     */
    public int getPublicationYear() {
        return this.publicationYear;
    }
    
    /**
     * Set the publication year
     * @param publicationYear int; the publication year
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    /**
     * Get the Book contents
     * @return String: the book contents
     */
    public String getContents() {
        return this.contents;
    }
    
    /**
     * Set the Book contents
     * @param contents String: the book contents
     */
    public void setContents(String contents) {
        this.contents = contents;
    }
    
    @Override
    /**
     * Return a String in the following format
     * Name: [name] ([publication year])
     * Contents: [contents]
     */
    public String toString() {
        return "Name: " + this.name + " (" + this.publicationYear + ")\n"
                + "Contents: " + this.contents;
    }
}
