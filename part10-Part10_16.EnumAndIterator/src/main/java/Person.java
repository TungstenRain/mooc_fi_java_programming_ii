/**
 * Person Class for Part10_16
 * @author frank
 */
public class Person {
    // Variables
    private String name;
    private Education education;
    
    // Constructors
    /**
     * Construct the Person
     * @param name String: the Person's name
     * @param education Education: the Person's education
     */
    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }
    
    // Methods
    public String getName() {
        return this.name;
    }
    public Education getEducation() {
        return this.education;
    }
    
    @Override
    /**
     * Return a String in the following format:
     * [name], [education]
     */
    public String toString() {
        return this.name + ", " + this.education;
    }
}
