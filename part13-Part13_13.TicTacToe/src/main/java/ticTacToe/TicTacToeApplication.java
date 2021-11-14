package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;

public class TicTacToeApplication extends Application {
    
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
    
    // Variables
    private boolean xState;
    private boolean finished;
    private Label labelStatus;
    private ArrayList<Button> buttons;
    
    // Constructor
    public TicTacToeApplication() {
        this.xState = true;
        this.finished = false;
        this.labelStatus = new Label("Turn: X");
        this.buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            this.buttons.add(createButton());
        }
    }
    
    // Methods
    @Override
    public void start(Stage primaryStage) {
        // Instantiate BorderPane and set properties
        BorderPane layout = new BorderPane();
        layout.setPrefSize(310, 350);
        labelStatus.setFont(new Font(30.0));
        
        // Instantiate the GridPane and set properties
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        // Add Buttons to the GridPane  
        grid.add(buttons.get(0), 1, 0);
        grid.add(buttons.get(1), 2, 0);
        grid.add(buttons.get(2), 3, 0);
        grid.add(buttons.get(3), 1, 1);
        grid.add(buttons.get(4), 2, 1);
        grid.add(buttons.get(5), 3, 1);
        grid.add(buttons.get(6), 1, 2);
        grid.add(buttons.get(7), 2, 2);
        grid.add(buttons.get(8), 3, 2);
        
        // Add components to the BorderPane
        layout.setTop(labelStatus);
        layout.setCenter(grid);
        
        // Instantiate the Scene
        Scene view = new Scene(layout);
        
        // Set the Scene and show
        primaryStage.setScene(view);
        primaryStage.show();
    }
    
    /**
     * Create a Button with the properties and functionality for tic-tac-toe
     * @return Button: a Button for tic-tac-toe
     */
    private Button createButton() {
        // Instantiate the Button and set properties
        Button button = new Button();
        button.setFont(new Font("Monospaced", 40));
        button.setPrefSize(90, 90);
        
        // Set button functionality
        button.setOnAction((event) -> {
            if (finished || (!button.getText().isEmpty())) {
                return;
            }
            
            if (xState) {
                button.setText("X");
                labelStatus.setText("Turn: O");
                xState = false;
            } else {
                button.setText("O");
                labelStatus.setText("Turn: X");
                xState = true;
            }

            if (gameCompleted() || gameWon()) {
                labelStatus.setText("The end!");
                finished = true;
            }
        });

        return button;
    }
    
    /**
     * Determine if all the Buttons have been used
     * @return boolean: true if they have all been used; false otherwise
     */
    private boolean gameCompleted() {
        for (Button button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Determine if the game was won by either X or O
     * @return boolean: true if the game was won; false otherwise
     */
    private boolean gameWon() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }
    
    /**
     * Determine if there are three in a row match on any of the rows
     * @return boolean: true if three in a row; false otherwise
     */
    private boolean checkRows() {
        return ((checkThree(buttons.get(0), buttons.get(1), buttons.get(2))) ||
                (checkThree(buttons.get(3), buttons.get(4), buttons.get(5))) ||
                (checkThree(buttons.get(6), buttons.get(7), buttons.get(8))));
    }
    
    /**
     * Determine if there are three in a row match on any of the columns
     * @return boolean: true if three in a row; false otherwise
     */
    private boolean checkColumns() {
        return ((checkThree(buttons.get(0), buttons.get(3), buttons.get(6))) ||
                (checkThree(buttons.get(1), buttons.get(4), buttons.get(7))) ||
                (checkThree(buttons.get(2), buttons.get(5), buttons.get(8))));
    }
    
    /**
     * Determine if there are three in a row match on either diagonal
     * @return boolean: true if three in a row; false otherwise
     */
    private boolean checkDiagonals() {
        return ((checkThree(buttons.get(0), buttons.get(4), buttons.get(8))) ||
                (checkThree(buttons.get(2), buttons.get(4), buttons.get(6))));
    }
    
    /**
     * Determine if three in a row match
     * @param buttonA Button: the first button to check
     * @param buttonB Button: the second button to check
     * @param buttonC Button: the third button to check
     * @return boolean: true if there are three in a row; false otherwise
     */
    private boolean checkThree(Button buttonA, Button buttonB, Button buttonC) {
        if ((!buttonA.getText().isEmpty()) && (buttonA.getText().equals(buttonB.getText())) && (buttonA.getText().equals(buttonC.getText()))) {
            return true;
        }
        
        return false;
    }
}