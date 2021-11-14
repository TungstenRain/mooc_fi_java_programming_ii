package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * Character Class for Part14_09
 * @author frank
 */
public abstract class Character {
    // Variables
    private Polygon character;
    private Point2D movement;
    private double[] velocity;
    private boolean alive;
    
    // Constructors
    /**
     * Construct the Character (Ship or Asteroid)
     * @param polygon Polygon: the shape of the character
     * @param x int: the x-coordinate
     * @param y int: the y-coordinate
     */
    public Character(Polygon polygon, int x, int y) {
        this.character = polygon;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        
        this.movement = new Point2D(0, 0);
        
        this.velocity = new double[]{0.0, 0.0};
        this.alive = true;
    }
    
    // Methods
    /**
     * Get the Character's Polygon
     * @return Polygon: the Character's character (shape)
     */
    public Polygon getCharacter() {
        return this.character;
    }
    
    /**
     * Get the Character's movement
     * @return Point2D: the Character's movement
     */
    public Point2D getMovement() {
        return this.movement;
    }
    
    /**
     * Set the Character's movement
     * @param move Point2D: the Characters movement
     */
    public void setMovement(Point2D movement) {
        this.movement = movement;
    }
    
    /**
     * Get the Character's in game status
     * @return boolean: true if alive, false otherwise
     */
    public boolean isAlive() {
        return this.alive;
    }
    
    /**
     * Set the Character's in game status 
     * @param value 
     */
    public void setAlive(boolean value) {
        this.alive = value;
    }
    
    /**
     * Rotate the Character left
     */
    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 5);
    }
    
    /**
     * Rotate the Character right
     */
    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 5);
    }
    
    /**
     * Move the Character
     */
    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());
        
        // Move the Character back in frame of the Pane
        if (this.character.getTranslateX() < 0) {
            this.character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
        }
        
        if (this.character.getTranslateX() > AsteroidsApplication.WIDTH) {
            this.character.setTranslateX(this.character.getTranslateX() % AsteroidsApplication.WIDTH);
        }
        
        if (this.character.getTranslateY() > 0) {
            this.character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
        }
        
        if (this.character.getTranslateY() > AsteroidsApplication.HEIGHT) {
            this.character.setTranslateY(this.character.getTranslateY() % AsteroidsApplication.HEIGHT);
        }
    }
    
    /**
     * Accelerate the Character in the direction it is pointing
     */
    public void accelerate() {
        this.changeVelocity();
        
        this.movement = this.movement.add(this.velocity[0], this.velocity[1]);
    }
    
    /**
     * Decelerate the Character in the direction it is pointing
     */
    public void decelerate() {
        this.changeVelocity();
        
        this.movement = this.movement.add(-this.velocity[0], -this.velocity[1]);
    }
    
    /**
     * Determine if the Character collides with another
     * @param other Character: the other Character object
     * @return boolean: true if they collide, false otherwise
     */
    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.character);
        return (collisionArea.getBoundsInLocal().getWidth() != -1);
    }
    
    /**
     * Change the velocity of the Character
     */
    private void changeVelocity() {
        double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.character.getRotate()));
        
        // Slow it down
        changeX *= 0.05;
        changeY *= 0.05;
        
        this.velocity[0] = changeX;
        this.velocity[1] = changeY;
    }
}
