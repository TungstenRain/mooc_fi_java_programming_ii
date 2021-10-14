/**
 * Abbreviations Class for Part08_07
 * @author frank
 */
import java.util.HashMap;

public class Abbreviations {
    // Variables
    private HashMap<String, String> abbreviations;
    
    // Constructors
    /**
     * Construct the Abbreviations
     */
    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }
    
    // Methods
    /**
     * Add an abbreviation to the Abbreviations
     * @param abbreviation String: the abbreviation key
     * @param explanation String: the explanation of the abbreviation
     */
    public void addAbbreviation(String abbreviation, String explanation) {
        if (!this.hasAbbreviation(abbreviation)) {
            this.abbreviations.put(this.sanitizeString(abbreviation), explanation);
        }
    }
    
    /**
     * Determine if the Abbreviations has a specific abbreviation
     * @param abbreviation String: the abbreviation key to check
     * @return boolean: true if the Abbreviation has it; false otherwise
     */
    public boolean hasAbbreviation(String abbreviation) {
        if (this.abbreviations.containsKey(this.sanitizeString(abbreviation))) {
            return true;
        }
        return false;
    }
    
    /**
     * Find the explanation for a given abbreviation
     * @param abbreviation String: the abbreviation key
     * @return String: the explanation of the abbreviation; null if there is no abbreviation key
     */
    public String findExplanationFor(String abbreviation) {
        if (!this.hasAbbreviation(abbreviation)) {
            return null;
        }
        return this.abbreviations.get(this.sanitizeString(abbreviation));
    }
    
    /**
     * Sanitize the String so it is lowercase and trimmed
     * @param string String: String to be sanitized
     * @return String: the sanitized String
     */
    private String sanitizeString(String string) {
        if (string == null) {
            return "";
        }
        return string.toLowerCase().trim();
    }
}
