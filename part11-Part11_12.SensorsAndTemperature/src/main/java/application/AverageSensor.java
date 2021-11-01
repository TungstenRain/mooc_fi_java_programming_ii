package application;

/**
 * AverageSensor Class for Part11_10
 * @author frank
 */
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    // Variables
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;
    
    // Constructors
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    // Methods
    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
    @Override
    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        if (this.sensors.isEmpty()) {
            throw new IllegalStateException("There are no sensors.");
        }
        if (!this.isOn()) {
            throw new IllegalStateException("Sensors are off.");
        }
        
        int average = (this.sensors.stream()
                .map(sensor -> sensor.read())
                .reduce(0, (subtotal, value) -> subtotal + value))/this.sensors.size();
        
        this.readings.add(average);
        
        return average;
    }
    
}
