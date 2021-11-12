package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate components
        BorderPane layout = new BorderPane();
        layout.setTop(new Label("NORTH"));
        layout.setRight(new Label("EAST"));
        layout.setBottom(new Label("SOUTH"));
        
        // Instantiate Scene
        Scene view = new Scene(layout);
        
        // Set Scene and Show
        primaryStage.setScene(view);
        primaryStage.show();
    }

}
