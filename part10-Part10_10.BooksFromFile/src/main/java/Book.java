
public class Book {
    // Variables
    private String name;
    private int publishingYear;
    private int pageCount;
    private String author;
    
    // Constructors
    /**
     * Construct the Book
     * @param name String: the name of the Book
     * @param ReleaseYear int: the year the Book was released
     * @param pages int: the number of pages in the Book
     * @param author String: the author of the Book
     */
    public Book(String name, int ReleaseYear, int pages, String author) {
        this.name = name;
        this.publishingYear = ReleaseYear;
        this.pageCount = pages;
        this.author = author;
    }
    
    // Methods
    /**
     * Get the Book name
     * @return String: the Book name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the publishing year
     * @return int: the publishing year
     */
    public int getPublishingYear() {
        return publishingYear;
    }
    
    /**
     * Get the Book's author
     * @return String: the author
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Get the number of pages in the book
     * @return int: the number of pages in the book
     */
    public int getPagecount() {
        return pageCount;
    }

}
