/**
 * DictionaryOfManyTranslations Class for Part08_14
 * @author frank
 */
import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    // Variables
    private HashMap<String, ArrayList<String>> dictionary;
    
    // Constructors
    /**
     * Construct the DictionaryOfManyTranslations
     */
    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }
    
    
    // Methods
    /**
     * Adds the translation for the word and preserves the old translations.
     * @param word String: the word
     * @param translation String: the translation
     */
    public void add(String word, String translation) {
        // Create a new ArrayList if one is absent
        this.dictionary.putIfAbsent(word, new ArrayList<>());
        
        // Add translation to the word
        this.dictionary.get(word).add(translation);
    }
    
    /**
     * Returns a list of the translations added for the word. 
     * If the word has no translations, the method should return an empty list.
     * @param word String: the word to search for
     * @return ArrayList<String>: the list of definitions for the word
     */
    public ArrayList<String> translate(String word) {
        ArrayList<String> translations = new ArrayList<>();
        if (this.dictionary.containsKey(word)) {
            for (String translation : this.dictionary.get(word)) {
                translations.add(translation);
            }
        }
        
        return translations;
    }
    
    /**
     * Removes the word and all its translations from the dictionary.
     * @param word String: the word to remove from the dictionary
     */
    public void remove(String word) {
        this.dictionary.remove(word);
    }
}
