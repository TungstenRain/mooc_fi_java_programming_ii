package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        Application.launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate components
        VBox firstPane = new VBox();
        VBox secondPane = new VBox();
        
        Label labelInstructions = new Label("Enter your name and start.");
        Label labelGreeting = new Label("Welcome ");
        TextField textFieldName = new TextField();
        Button buttonStart = new Button("Start");
        
        // Add components to their respective views
        firstPane.setSpacing(10);
        firstPane.getChildren().addAll(labelInstructions, textFieldName, buttonStart);
        
        secondPane.setSpacing(10);
        secondPane.getChildren().add(labelGreeting);
        
        // Instantiate Scenes
        Scene firstView = new Scene(firstPane);
        Scene secondView = new Scene(secondPane);
        
        // Button Functionality
        buttonStart.setOnAction((event) -> {
            labelGreeting.setText("Welcome " + textFieldName.getText() + "!");
            primaryStage.setScene(secondView);
        });
        
        // Set Scene and show
        primaryStage.setScene(firstView);
        primaryStage.show();
    }
}
