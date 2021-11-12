package textstatistics;

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
        
        // Set spacing and add labels to the HBox
        bottomLabels.setSpacing(10);
        bottomLabels.getChildren().add(new Label("Letters: 0"));
        bottomLabels.getChildren().add(new Label("Words: 0"));
        bottomLabels.getChildren().add(new Label("The longest word is:"));
        
        // Order the BorderPane
        layout.setCenter(new TextArea());
        layout.setBottom(bottomLabels);
        
        // Instantiate the Scene
        Scene view = new Scene(layout);
        
        // Set the Scene and show
        primaryStage.setScene(view);
        primaryStage.show();
        
    }

}
