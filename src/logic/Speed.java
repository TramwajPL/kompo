package logic;

public class Speed {
    private double speed = 0.0;
    private double acceleration = 0.0;
    private double airResistance = 0.6;
    private final double MAX_SPEED_LIMIT = 200.0;
    private final double MIN_SPEED_LIMIT = 0.0;
    private final double ACC_MULTIPLIER = 0.002;
    private final double BRAKE_MULTIPLIER = 3.0;

    Speed() {}

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
        speed -= BRAKE_MULTIPLIER * acceleration;
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

    public double getSpeed() {
        return speed;
    }

    public String getSpeedAsString() {
        return String.valueOf((int)speed);
    }

    public int getSpeedAsInt() {
        return (int) speed;
    }
}