package collage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {
    
    public static void main(String[] args) {
        Application.launch(CollageApplication.class);
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Instantiate the Image from the file
        Image sourceImage = new Image("file:monalisa.png");
        
        // Instantiate the PixelReader so it reads the image pixel by pixel (so it can be manipulated)
        PixelReader imageReader = sourceImage.getPixelReader();
        
        // Get the dimensions
        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();
        
        // Instantiate the WritableImage using the width and height
        // Instantiate the PixelWriter so the image can be written pixel by pixel
        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();
        
        // Draw the image pixel by pixel
        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {
                
                // Invert the colors
                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();
                
                Color newColor = new Color(red, green, blue, opacity);
                
                // Set the upper-left image
                imageWriter.setColor(xCoordinate / 2, yCoordinate / 2, newColor);
                // Set the upper-right image
                imageWriter.setColor((width / 2 + xCoordinate / 2), yCoordinate / 2, newColor);
                // Set the lower-left image
                imageWriter.setColor(xCoordinate / 2, (height / 2 + yCoordinate / 2), newColor);
                // Set the lower-right image
                imageWriter.setColor((width / 2 + xCoordinate / 2), (height / 2 + yCoordinate / 2), newColor);
                
                // Increment the xCoordinate by 2 as opposed to 1
                xCoordinate+= 2;
            }
            
            // Increment the yCoordinate by 2 as opposed to 1
            yCoordinate+= 2;
        }
        
        // Instantiate the ImageView
        ImageView image = new ImageView(targetImage);
        
        // Instantiate the Pane and add the image to it
        Pane pane = new Pane();
        pane.getChildren().add(image);
        
        // Instantiate the Scene, set the Scene, and show
        Scene view = new Scene(pane);
        primaryStage.setScene(view);
        primaryStage.show();
    }
}
