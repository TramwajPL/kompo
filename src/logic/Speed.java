package logic;

import java.text.ParseException;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="szybkoœæ")
public class Speed {
    private double speed = 0.0;
    private double acceleration = 0.0;
    private double airResistance = 0.3;
    private final double MAX_SPEED_LIMIT = 200.0;
    private final double MIN_SPEED_LIMIT = 0.0;
    private final double ACC_MULTIPLIER = 0.002;
    private final double BRAKE_MULTIPLIER = 8.0;

    Speed() {}

    public Speed(double speed, double acceleration, double airResistance) {
    	this.speed = speed;
    	this.acceleration = acceleration;
    	this.airResistance = airResistance;
    }
    
    public void setAirResistance(double airResistance) {
        this.airResistance = airResistance;
    }

    private void calculateAcceleration() {
        acceleration = (MAX_SPEED_LIMIT - speed) * ACC_MULTIPLIER;
    }

    public void accelerate() {
        calculateAcceleration();
        speed += acceleration;
    }

    public void brake() {
        speed -= airResistance * BRAKE_MULTIPLIER * acceleration;
        speedNoLowerThanZero();
    }

    public void airResistanceEffect() {
        speed -= airResistance;
        speedNoLowerThanZero();
    }

    private void speedNoLowerThanZero() {
        if (speed < MIN_SPEED_LIMIT) {
            speed = MIN_SPEED_LIMIT;
        }
    }

    public String speedToString() {
        return String.valueOf((int)speed);
    }

	@XmlAttribute(name="wartoœæSzybkoœci")
    public int getSpeed() {
        return (int) speed;
    }
	
	@XmlAttribute(name="przyspieszenie")
    public int getAcceleration() {
        return (int) acceleration;
    }
	
	@XmlAttribute(name="opórPowietrza")
    public int getAirResistance() {
        return (int) airResistance;
    }
}