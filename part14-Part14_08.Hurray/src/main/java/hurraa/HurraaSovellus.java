package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {
    
    public static void main(String[] args) {
        Application.launch(HurraaSovellus.class);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate the BorderPane
        BorderPane layout = new BorderPane();
        
        // Instantiate the Button and add it to the BorderPane
        Button buttonHurray = new Button("Hurray!");
        layout.setCenter(buttonHurray);
        
        // Instantiate the AudioClip
        AudioClip audio = new AudioClip("file:Applause-Yannick_Lemieux.wav");
        
        // Set event handler for the button to play the sound onClick
        buttonHurray.setOnMouseClicked((event) -> {
            audio.play();
        });
        
        // Instantiate the Scene, set the Scene, show
        Scene view = new Scene(layout, 600, 400);
        primaryStage.setScene(view);
        primaryStage.show();
    }

    

}
