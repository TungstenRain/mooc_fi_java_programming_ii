package application;

/**
 * Dictionary Class for Part13_12
 * @author frank
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Dictionary {
    // Variables
    private List<String> words;
    private Map<String, String> translations;
    
    // Constructors
    /**
     * Construct the Dictionary
     */
    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();

        add("sana", "word");
    }
    
    // Methods
    /**
     * Get the translation of the word
     * @param word String: the word to look up
     * @return String: the translation
     */
    public String get(String word) {
        return this.translations.get(word);
    }
    
    /**
     * Add a word and its translation to the Dictionary
     * @param word String: the word
     * @param translation String: the translation
     */
    public void add(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }

        this.translations.put(word, translation);
    }
    
    /**
     * Get a random word from the the Dictionary
     * @return String: the randomized word
     */
    public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
}
