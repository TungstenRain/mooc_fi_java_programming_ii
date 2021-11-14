package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        Application.launch(MultipleViews.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate components for the different views
        BorderPane firstPane = new BorderPane();
        VBox secondPane = new VBox();
        GridPane thirdPane = new GridPane();
        
        Label labelFirstView = new Label("First view!");
        Label labelSecondView = new Label("Second view!");
        Label labelThirdView = new Label("Third view!");
        Button buttonFirstView = new Button("To the second view!");
        Button buttonSecondView = new Button("To the third view!");
        Button buttonThirdView = new Button("To the first view!");
        
        // Instantiate the Scenes
        Scene firstView = new Scene(firstPane);
        Scene secondView = new Scene(secondPane);
        Scene thirdView = new Scene(thirdPane);
        
        // Add components to their respective views
        firstPane.setTop(labelFirstView);
        firstPane.setCenter(buttonFirstView);
        
        secondPane.setSpacing(10);
        secondPane.getChildren().addAll(buttonSecondView, labelSecondView);
        
        thirdPane.setPadding(new Insets(10, 10, 10, 10));
        thirdPane.setVgap(5);
        thirdPane.setHgap(5);
        thirdPane.add(labelThirdView, 0, 0);
        thirdPane.add(buttonThirdView, 1, 1);
        
        // Button functionality
        buttonFirstView.setOnAction((event) -> {
            primaryStage.setScene(secondView);
        });
        
        buttonSecondView.setOnAction((event) -> {
            primaryStage.setScene(thirdView);
        });
        
        buttonThirdView.setOnAction((event) -> {
            primaryStage.setScene(firstView);
        });
        
        // Set the Scene and show
        primaryStage.setScene(firstView);
        primaryStage.show();
    }

}
