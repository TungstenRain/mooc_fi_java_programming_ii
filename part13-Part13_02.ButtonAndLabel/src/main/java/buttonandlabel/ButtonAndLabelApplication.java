package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window) {
        // Instantiate components
        Button button = new Button("This is a button");
        Label textLabel = new Label("Text element");
        FlowPane componentGroup = new FlowPane();
        
        // Add components to the FlowPane
        componentGroup.getChildren().add(textLabel);
        componentGroup.getChildren().add(button);
        
        // Instantiate a new Scene using the FlowPane
        Scene view = new Scene(componentGroup);
        
        // Set the Scene and show
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
