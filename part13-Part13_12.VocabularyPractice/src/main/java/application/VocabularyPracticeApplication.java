package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {
    // Variable
    private Dictionary dictionary;
    
    public static void main(String[] args) {
        Application.launch(VocabularyPracticeApplication.class);
    }
    
    @Override
    public void init() throws Exception {
        // Instantiate the dictionary
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate the views
        PracticeView practiceView = new PracticeView(this.dictionary);
        InputView inputView = new InputView(this.dictionary);
        
        // Instantiate the high-level layout
        BorderPane layout = new BorderPane();
        
        // Instantiate components for the menu
        HBox menu = new HBox();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setSpacing(10);
        
        // Instantiate Buttons
        Button buttonEnter = new Button("Enter new words");
        Button buttonPractice = new Button("Practice");
        
        // Add components to the HBox
        menu.getChildren().addAll(buttonEnter, buttonPractice);
        layout.setTop(menu);
        
        // Button functionality
        buttonEnter.setOnAction((event) -> {
            layout.setCenter(inputView.getView());
        });
        
        buttonPractice.setOnAction((event) -> {
            layout.setCenter(practiceView.getView());
        });
        
        // Set the first view
        layout.setCenter(inputView.getView());
        
        // Instantiate Scene
        Scene view = new Scene(layout, 400, 300);
        
        // Set the Scene and show
        primaryStage.setScene(view);
        primaryStage.show();
    }
}
