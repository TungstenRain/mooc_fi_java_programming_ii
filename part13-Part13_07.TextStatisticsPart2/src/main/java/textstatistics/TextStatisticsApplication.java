package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate components
        BorderPane layout = new BorderPane();
        HBox bottomLabels = new HBox();
        TextArea textArea = new TextArea();
        Label labelLetterCount = new Label("Letters: 0");
        Label labelWordCount = new Label("Words: 0");
        Label labelLongestWord = new Label("The longest word is:");
        
        // Set spacing and add labels to the HBox
        bottomLabels.setSpacing(10);
        bottomLabels.getChildren().add(labelLetterCount);
        bottomLabels.getChildren().add(labelWordCount);
        bottomLabels.getChildren().add(labelLongestWord);
        
        // Add event handling for when user types in the TextArea
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            // Count the characters
            int characterCount = newValue.length();
            
            // Count the words
            String[] words = newValue.split(" ");
            int wordCount = words.length;
            
            // Find the longest word
            String longestWord = Arrays.stream(words)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            // Set the text in the Labels
            labelLetterCount.setText("Letters: " + characterCount);
            labelWordCount.setText("Words: " + wordCount);
            labelLongestWord.setText("The longest word is: " + longestWord);
        });
        
        // Order the BorderPane
        layout.setCenter(textArea);
        layout.setBottom(bottomLabels);
        
        // Instantiate the Scene
        Scene view = new Scene(layout);
        
        // Set the Scene and show
        primaryStage.setScene(view);
        primaryStage.show();
        
    }

}
