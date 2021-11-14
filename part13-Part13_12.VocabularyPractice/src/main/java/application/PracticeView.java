package application;

/**
 * PracticeView Class for Part13_12
 * @author frank
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    // Variables
    private Dictionary dictionary;
    private String word;
    
    // Constructors
    /**
     * Construct the PracticeView
     * @param dictionary Dictionary: the dictionary
     */
    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }
    
    // Methods
    /**
     * Get the view
     * @return Parent: the view
     */
    public Parent getView() {
        // Instantiate the GridPane
        GridPane layout = new GridPane();
        
        // Instantiate the components
        Label wordInstruction = new Label("Translate the word '" + this.word + "'");
        TextField translationField = new TextField();
        
        // Set the GridPane settings
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        // Instantiate the Button and Label
        Button addButton = new Button("Check");
        
        Label feedback = new Label("");
        
        // Add components to the GridPane
        layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(addButton, 0, 2);
        layout.add(feedback, 0, 3);
        
        // Button functionality to practice the word and its definition
        addButton.setOnMouseClicked((event) -> {
            String translation = translationField.getText();
            if (dictionary.get(word).equals(translation)) {
                feedback.setText("Correct!");
            } else {
                feedback.setText("Incorrect! The translation fo the word '" + word + "' is '" + dictionary.get(word) + "'.");
                return;
            }
            
            this.word = this.dictionary.getRandomWord();
            wordInstruction.setText("Translate the word '" + this.word + "'");
            translationField.clear();
        });
        
        return layout;
    }
}
