/**
 * LiteracyData Class for Part10_11
 * @author frank
 */
public class LiteracyData implements Comparable<LiteracyData> {
    // Variables
    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double literacyPercent;
    
    // Constructors
    /**
     * Construct the LiteracyData
     * @param theme String: the theme
     * @param ageGroup String: the age group
     * @param gender String: the gender of the group
     * @param country String: the country
     * @param year int: the year
     * @param literacyPercent double: the literacy rate
     */
    public LiteracyData(String theme, String ageGroup, String gender, String country, int year, double literacyPercent) {
        this.theme = theme;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }
    public LiteracyData() {
        this("", "", "", "", 0, 0.0);
    }
    
    // Methods
    /**
     * Get the theme
     * @return String: the theme
     */
    public String getTheme() {
        return this.theme;
    }
    /**
     * Get the age group
     * @return String: the age group
     */
    public String getAgeGroup() {
        return this.ageGroup;
    }
    /**
     * Get the gender
     * @return String: the gender
     */
    public String getGender() {
        return this.gender;
    }
    /**
     * Get the country
     * @return String: the country
     */
    public String getCountry() {
        return this.country;
    }
    /**
     * Get the year
     * @return int: the year
     */
    public int getYear() {
        return this.year;
    }
    /**
     * Get the literacy percent
     * @return double: the literacy percent
     */
    public double getLiteracyPercent() {
        return this.literacyPercent;
    }
    
    @Override
    /**
     * Return a String in the following format
     * [country] ([year]), [gender], [literacy percent]
     */
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacyPercent;
    }
    
    // Methods
    @Override
    public int compareTo(LiteracyData compared) {
        return Double.compare(this.literacyPercent, compared.literacyPercent);
    }
    
}
