package dictionary;

/**
 * SaveableDictionary for Part11_13
 * @author frank
 */

import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveableDictionary {
    // Variables
    private ArrayList<String[]> dictionary;
    private File file;
    
    // Constructors
    public SaveableDictionary(String file) {
        this.dictionary = new ArrayList<>();
        this.file = new File(file);
    }
    public SaveableDictionary() {
        this("");
    }
    
    // Methods
    /**
     * Adds a word to the dictionary. Every word has just one translation, 
     * and if the same word is added for the second time, nothing happens.
     * @param words String: the word
     * @param translation String: the translation
     */
    public void add(String words, String translation) {
        String[] pairing = new String[2];
        pairing[0] = words;
        pairing[1] = translation;
        
        if (!this.dictionary.isEmpty()) {
            for (String[] pair : this.dictionary) {
                if (pair[0].equals(pairing[0]) || pair[1].equals(pairing[0])) {
                    return;
                }
            }
        }
        this.dictionary.add(pairing);
    }
    
    /**
     * Returns the translation for the given word. If the word is not in the 
     * dictionary, returns null.
     * @param word String: the word to look up
     * @return String: the translation of that word
     */
    public String translate(String word) {
        // This will loop through each pairing in the dictionary and give the translation by checking both parts of the array
        for (String[] pair : this.dictionary) {
            // Check the first position
            if (pair[0].equals(word)) {
                return pair[1];
            }
            // Check the second position
            if (pair[1].equals(word)) {
                return pair[0];
            }
        }
        return null;
    }
    
    /**
     * Deletes the word from the dictionary regardless which side of the translation equation
     * @param word String: the word to delete
     */
    public void delete(String word) {
        for (int i = 0; i < this.dictionary.size(); i++) {
            if (this.dictionary.get(i)[0].equals(word) || this.dictionary.get(i)[1].equals(word)) {
                this.dictionary.remove(i);
            }
        }
    }
    
    /**
     * Loads dictionary information from a file
     * @return boolean: true if successful, false otherwise
     */
    public boolean load() {
        try {
            // Instantiate Scanner
            Scanner fileReader = new Scanner(Paths.get(this.file.getName()));
            
            while(fileReader.hasNextLine()) {
                // Capture what is on the line
                String line = fileReader.nextLine();
                
                // Splite the line into different parts
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            fileReader.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }
    
    public boolean save() {
        try {
            // Instantiate the PrintWriter
            PrintWriter writer = new PrintWriter(this.file.getName());
            
            // Write the words to the file
            for (String[] pairing : this.dictionary) {
                writer.println(pairing[0] + ":" + pairing[1]);
            }
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
