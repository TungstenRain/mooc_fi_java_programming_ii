package asteroids;

/**
 * Ship Class for Part14_09
 * @author frank
 */

import javafx.scene.shape.Polygon;

public class Ship extends Character {
    // Constructors
    /**
     * Construct the Ship
     * @param x int: the x-coordinate
     * @param y int: the y-coordinate
     */
    public Ship(int x, int y) {
        super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
    }
}
