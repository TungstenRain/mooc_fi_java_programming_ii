package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        Application.launch(JokeApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate the components
        BorderPane layout = new BorderPane();
        
        // Instantiate components for menu
        HBox menu = new HBox();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setSpacing(10);
        
        Button buttonQuestion = new Button("Joke");
        Button buttonAnswer = new Button("Answer");
        Button buttonExplanation = new Button("Explanation");
        
        // Add components to menu
        menu.getChildren().addAll(buttonQuestion, buttonAnswer, buttonExplanation);
        
        layout.setTop(menu);
        
        // Instantiate StackPane
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("An animal with no teeth only has gums.\nA gummy bear is also a soft, chewable gelatin treat.");
        
        // Button functionality
        buttonQuestion.setOnAction((event) -> {
            layout.setCenter(jokeLayout);
        });
        
        buttonAnswer.setOnAction((event) -> {
            layout.setCenter(answerLayout);
        });
        
        buttonExplanation.setOnAction((event) -> {
            layout.setCenter(explanationLayout);
        });
        
        layout.setCenter(jokeLayout);
        
        // Instantiate Scene
        Scene view = new Scene(layout);
        
        // Set the Scene and show
        primaryStage.setScene(view);
        primaryStage.show();
        
    }
    
    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
