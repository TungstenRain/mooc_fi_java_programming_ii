package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate components
        VBox layout = new VBox();
        TextField textField = new TextField();
        Button button = new Button("Update");
        Label label = new Label();
        
        // Button functionality
        button.setOnAction((event) -> {
            label.setText(textField.getText());
        });
        
        // Set spacing and add components to VBox
        layout.setSpacing(10);
        layout.getChildren().addAll(textField, button, label);
        
        // Instantiate Scene
        Scene view = new Scene(layout);
        
        // Set the scene and show
        primaryStage.setScene(view);
        primaryStage.show();
    }

}
