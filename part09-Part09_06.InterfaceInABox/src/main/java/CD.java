/**
 * CD Class for Part09_06
 * @author frank
 */
public class CD implements Packable {
    // Variables
    private String artist;
    private String name;
    private int publicationYear;
    private final double weight = 0.1;
    
    // Constructors
    /**
     * Construct the CD
     * @param artist String: the CD artist
     * @param name String: the CD name
     * @param publicationYear int: the year the CD was published
     */
    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }
    
    
    // Methods
    @Override
    /**
     * Returns the CD weight
     * @return double: the CD weight
     */
    public double weight() {
        return this.weight;
    }
    
    @Override
    /**
     * Return a String in the following format:
     * [artist]: [album name] ([publication year])
     */
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.publicationYear + ")";
    }
}
