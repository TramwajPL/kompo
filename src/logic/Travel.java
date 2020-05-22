package logic;

import java.util.Timer;

public class Travel{

    private Speed speed = new Speed();
    private TravelInformation travelInformation = new TravelInformation();
    private boolean isCruiseControlActive = false;

    public Travel() {
        TravelTasks travelTasks = new TravelTasks(speed, travelInformation);
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(travelTasks, 0, 1000);

        //odpalane na koniec dzialania programu
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                //TOooooooooooooooooooo
            }
        }));
    }

    public void resetFirstOdometer(){
        travelInformation.setFirstDailyOdometerValue(0);
    }

    public void resetSecondOdometer(){
        travelInformation.setSecondDailyOdometerValue(0);
    }

    public double getFirstOdometerValue(){
        return travelInformation.getFirstDailyOdometerValue();
    }

    public  double getSecondOdometerValue(){
        return travelInformation.getSecondDailyOdometerValue();
    }

    public int getJourneyTime(){
        return travelInformation.getTotalTravelTime();
    }

    public double getTotalDistance(){
        return travelInformation.getTotalDistance();
    }

    public double getFuelConsumed() { return travelInformation.getFuelConsumed(); }

    public int getAverageSpeed() { return travelInformation.getAverageSpeed(); }

    public void accelerate(){
        speed.accelerate();
    }

    public void brake(){
        speed.brake();
    }

    public String getSpeedAsString(){
        return speed.getSpeedAsString();
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
