package logic;

import java.util.Timer;

public class Travel{

    private Speed speed = new Speed();

    public Travel() {
        Timer timer = new Timer(true);
        TravelTasks travelTasks = new TravelTasks(speed);
        timer.scheduleAtFixedRate(travelTasks, 10, 500);
    }

    public String getSpeedString(){
        return speed.speedToString();
    }

    public void accelerate(){
        speed.accelerate();
    }

    public void brake(){
        speed.brake();
    }

    public void cruiseControlModeOn(){
        speed.setAirResistance(0.0);
    }

    public void cruiseControlModeOff(){
        speed.setAirResistance(0.3);
    }
}
