package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
    // Variables
    public static int WIDTH = 300;
    public static int HEIGHT = 200;
    
    public static void main(String[] args) {
        Application.launch(AsteroidsApplication.class);
    }
    
    /**
     * This is just for the test to determine how much has been completed
     * @return 
     */
    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate the main Pane
        Pane layout = new Pane();
        layout.setPrefSize(WIDTH, HEIGHT);
        
        // Instantiate the scoreboard
        Text textScore = new Text(10, 20, "Points: 0");
        layout.getChildren().add(textScore);
        
        // Instantiate the AtomicInteger to handle scores
        AtomicInteger points = new AtomicInteger();
        
        // Instantiate the Ship, Asteroids, and Projectiles
        Ship ship = new Ship(WIDTH / 2 , HEIGHT / 2);
        List<Character> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            Asteroid asteroid = new Asteroid(random.nextInt(WIDTH / 3), random.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }
        List<Character> projectiles = new ArrayList<>();
        
        // Add the Ship to the Pane
        layout.getChildren().add(ship.getCharacter());
        asteroids.stream()
                .forEach(asteroid -> layout.getChildren().add(asteroid.getCharacter())
                );
        
        // Instantiate Scene
        Scene view = new Scene(layout);
        
        // Instantiate Map to handle KeyPress events
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        // Add event handlers for OnKeyPress and OnKeyRelease events
        view.setOnKeyPressed((event) -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        
        view.setOnKeyReleased((event) -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        
        
        // Instantiate the AnimationTimer to handle Ship and Asteroid movement
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Rotate the Ship Left
                if (pressedKeys.getOrDefault(KeyCode.LEFT, Boolean.FALSE)) {
                    ship.turnLeft();
                }
                
                // Rotate the Ship Right
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, Boolean.FALSE)) {
                    ship.turnRight();
                }
                
                // Accelerate the Ship
                if (pressedKeys.getOrDefault(KeyCode.UP, Boolean.FALSE)) {
                    ship.accelerate();
                }
                
                // Decelerate the Ship
                if (pressedKeys.getOrDefault(KeyCode.DOWN, Boolean.FALSE)) {
                    ship.decelerate();
                }
                
                // Shoot a Projectile
                if ((pressedKeys.getOrDefault(KeyCode.SPACE, Boolean.FALSE)) && (projectiles.size() < 3)) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);
                    
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                    
                    layout.getChildren().add(projectile.getCharacter());
                }
                
                // Move the Ship, Asteroids, and Projectiles
                ship.move();
                asteroids.stream()
                        .forEach(asteroid -> asteroid.move());
                projectiles.stream()
                        .forEach(projectile -> projectile.move());
                
                // Stop the game if the Ship collides with an Asteroid
                asteroids.stream()
                        .forEach(asteroid -> {
                            if (ship.collide(asteroid)) {
                                stop();
                            }
                        });
                
                // Set the in game status if a projectile hits an asteroid and add points if successful
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if(projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });
                    
                    if (!projectile.isAlive()) {
                        textScore.setText("Points: " + points.addAndGet(1000));
                    }
                });
                
                // Determine if the projectile is still alive. If not, remove it
                characterRemovalProcess(projectiles, layout);
                characterRemovalProcess(asteroids, layout);
                
                // Randomly add a new Asteroid to the game
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        layout.getChildren().add(asteroid.getCharacter());
                    }
                }
            }
        }.start();
        
        // Set Scene, and show
        primaryStage.setTitle("Asteroids!");
        primaryStage.setScene(view);
        primaryStage.show();
    }
    
    /**
     * Determine if a Character is still alive and if not, remove it
     * @param characters List<Character>: the List of Asteroids or Projectiles
     * @param pane Pane: the main Pane
     */
    private void characterRemovalProcess(List<Character> characters, Pane pane) {
        characters.stream()
                        .filter(character -> !character.isAlive())
                        .forEach(character -> {
                            pane.getChildren().remove(character.getCharacter());
                        });
                characters.removeAll(characters.stream()
                                                .filter(character -> !character.isAlive())
                                                .collect(Collectors.toList())
                );
    }

}
