/**
 * Checker Class for Part10_15
 * @author frank
 */

public class Checker {
    // Methods
    /**
     * Determine if a String is a day of the week
     * Abbreviations only: mon, tue, wed, thu, fri, sat, sun
     * @param string String: the String to check
     * @return boolean: true if it matches the abbreviation; false otherwise
     */
    public boolean isDayOfWeek(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    /**
     * Determine if all the letters in a String are all vowels (a, e, i, o, u)
     * @param string String: the String to check
     * @return boolean: true if they are all vowels; false otherwise
     */
    public boolean allVowels(String string) {
        return string.matches("[aeiou]*");
    }
    
    /**
     * Determine if a String is in a time format:
     * hh:mm:ss (24-hour clock)
     * @param string String: the String to check
     * @return boolean: true if in time format; false otherwise
     */
    public boolean timeOfDay(String string) {
        return string.matches("([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
    }
}
