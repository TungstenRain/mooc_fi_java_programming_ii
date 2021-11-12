package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate components
        Button button = new Button("This is a button");
        TextField textField = new TextField();
        FlowPane componentGroup = new FlowPane();
        
        // Add components to the FlowPane
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(textField);
        
        // Instantiate Scene
        Scene view = new Scene(componentGroup);
        
        // Set Scene and show
        primaryStage.setScene(view);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}
