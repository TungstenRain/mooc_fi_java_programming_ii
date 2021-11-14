package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class SmileyApplication extends Application {
    
    public static void main(String[] args) {
        Application.launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate Canvas and GraphicsContext
        Canvas paintingCanvas = new Canvas(1000, 1000);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        // Draw the left eye
        painter.fillRect((paintingCanvas.getWidth() / 10) * 2, paintingCanvas.getHeight() / 5, 100, 100);
        // Draw the right eye
        painter.fillRect((paintingCanvas.getWidth() / 10) * 6, paintingCanvas.getHeight() / 5, 100, 100);
        // Draw left corner of the mouth
        painter.fillRect((paintingCanvas.getWidth() / 10), (paintingCanvas.getHeight() / 5) * 3, 100, 100);
        // Draw the middle part of the mouth
        painter.fillRect(100 + (paintingCanvas.getWidth() / 10), 100 + (paintingCanvas.getHeight() / 5) * 3, 500, 100);
        // Draw the right corner of the mouth
        painter.fillRect(100 + (paintingCanvas.getWidth() / 10) * 6, (paintingCanvas.getHeight() / 5) * 3, 100, 100);
        
        // Instantiate BorderPane for the main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(paintingCanvas);
        
        // Instantiate the Scene, set the Scene, and show
        Scene view = new Scene(mainLayout);
        primaryStage.setScene(view);
        primaryStage.show();
    }

}
