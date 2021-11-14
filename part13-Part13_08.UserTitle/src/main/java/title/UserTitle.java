package title;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parameters parameters = getParameters();
        String title = parameters.getNamed().get("title");
        
        // Set the title of the Stage and show
        primaryStage.setTitle(title);
        primaryStage.show();
    }


}
