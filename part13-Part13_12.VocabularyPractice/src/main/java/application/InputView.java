package application;

/**
 * Input View for Part13_12
 * @author frank
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    // Variables
    private Dictionary dictionary;
    
    // Constructors
    /**
     * Construct the InputView
     * @param dictionary Dictionary: the Dictionary
     */
    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    
    // Methods
    /**
     * Get the view
     * @return Parent: the layout
     */
    public Parent getView() {
        // Instantiate the GridPane
        GridPane layout = new GridPane();
        
        // Instantiate components
        Label wordInstruction = new Label("Word");
        TextField wordField = new TextField();
        Label translationInstruction = new Label("Translation");
        TextField translationField = new TextField();
        
        // Set the GridPane settings
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        // Instanatiate the Button
        Button addButton = new Button("Add the word pair");
        
        // Add components to the GridPane
        layout.add(wordInstruction, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translationInstruction, 0, 2);
        layout.add(translationField, 0, 3);
        layout.add(addButton, 0, 4);
        
        // Button Functionality to add a word to the Dictionary
        addButton.setOnMouseClicked((event) -> {
            String word = wordField.getText();
            String translation = translationField.getText();
            
            dictionary.add(word, translation);
            
            wordField.clear();
            translationField.clear();
        });
        
        return layout;
    }
}
