package application;

/**
 * TemperatureSensor for Part11_10
 * @author frank
 */
public class TemperatureSensor implements Sensor {
    // Variables
    private boolean status;
    
    // Constructors
    public TemperatureSensor() {
        this.status = false;
    }
    
    // Methods
    private int getRandomTemperature() {
        return (int) ((Math.random() * 60) - 30);
    }
    
    @Override
    public boolean isOn() {
        return this.status;
    }

    @Override
    public void setOn() {
        this.status = true;
    }

    @Override
    public void setOff() {
        this.status = false;
    }

    @Override
    public int read() {
        if (!this.status) {
            throw new IllegalStateException("The TemperatureSensor is off.");
        }
        return this.getRandomTemperature();
    }
    
}
