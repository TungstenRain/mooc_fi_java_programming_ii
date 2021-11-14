package asteroids;

import java.util.Random;

/**
 * Asteroid Class for Part14_09
 * @author frank
 */
public class Asteroid extends Character {
    // Variables
    private double rotationalMovement;
    
    // Constructors
    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);
        
        // Instantiate Random to generate random movement and positioning
        Random random = new Random();
        
        super.getCharacter().setRotate(random.nextInt(10));
        
        int accelerationAmount = 1 + random.nextInt(10);
        for (int i = 0; i < accelerationAmount; i++) {
            super.accelerate();
        }
        
        this.rotationalMovement = 0.5 - random.nextDouble();
    }
    
    // Methods
    @Override
    public void move() {
        super.move();
        super.getCharacter().setRotate(super.getCharacter().getRotate() + this.rotationalMovement);
    }
}
