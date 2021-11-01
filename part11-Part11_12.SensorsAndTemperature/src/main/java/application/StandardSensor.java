package application;

/**
 * StandardSensor Class for Part11_12
 * @author frank
 */
public class StandardSensor implements Sensor {
    // Variables
    private int number;
    
    // Constructors
    public StandardSensor(int number) {
        this.number = number;
    }
    
    // Methods
    
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        
    }

    @Override
    public void setOff() {
        
    }

    @Override
    public int read() {
        return this.number;
    }
    
}
