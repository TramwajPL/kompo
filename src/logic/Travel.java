package logic;

import java.util.Timer;

public class Travel{

    private Speed speed = new Speed();
    private TravelInformation distance = new TravelInformation();
    private boolean isCruiseControlActive = false;

    public Travel() {
        TravelTasks travelTasks = new TravelTasks(speed,distance);
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(travelTasks, 0, 1000);

        //odpalane na koniec dzialania programu
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println(speed.getSpeedAsString());
                distance.getAverageSpeed();
            }
        }));
    }

    public void resetFirstOdometer(){
        distance.setFirstDailyOdometerValue(0);
    }

    public void resetSecondOdometer(){
        distance.setSecondDailyOdometerValue(0);
    }

    public double getFirstOdometerValue(){
        return distance.getFirstDailyOdometerValue();
    }

    public  double getSecondOdometerValue(){
        return distance.getSecondDailyOdometerValue();
    }

    public String getSpeedAsString(){
        return speed.getSpeedAsString();
    }

    public double getTotalDistance(){
        return distance.getTotalDistance();
    }

    public void accelerate(){
        speed.accelerate();
    }

    public void brake(){
        speed.brake();
    }

    public int getJourneyTime(){
        return distance.getTotalTravelTime();
    }

    public void cruiseController(){
        if(!isCruiseControlActive) {
            speed.setAirResistance(0.0);
            isCruiseControlActive = true;
        }
        else {
            speed.setAirResistance(0.3);
            isCruiseControlActive = false;
        }
    }

}
