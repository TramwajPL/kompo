package logic;

import java.util.Timer;

/**
 * Klasa s�u��ca do oblczania przebytej drogi
 */
public class Travel{

    private Speed speed = new Speed();
    private TravelInformation travelInformation = new TravelInformation();
    private boolean isCruiseControlActive = false;

    /**
     * Bezparametrowy konstruktor klasy Travel
     */
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

    /**
     * 
     */
    public void resetFirstOdometer(){
        travelInformation.setFirstDailyOdometerValue(0);
    }

    /**
     * 
     */
    public void resetSecondOdometer(){
        travelInformation.setSecondDailyOdometerValue(0);
    }

    /**
     * 
     */
    public double getFirstOdometerValue(){
        return travelInformation.getFirstDailyOdometerValue();
    }

    /**
     * 
     */
    public  double getSecondOdometerValue(){
        return travelInformation.getSecondDailyOdometerValue();
    }

    /**
     * Funkcja zwracaj�ca czas podr�y
     * @return
     */
    public int getJourneyTime(){
        return travelInformation.getTotalTravelTime();
    }

    /**
     * Funkcja zwracaj�ca ca�kowity pokonany dystans
     * @return
     */
    public double getTotalDistance(){
        return travelInformation.getTotalDistance();
    }

    /**
     * Funkcja zwracaj�ca spalone paliwo
     * @return
     */
    public double getFuelConsumed() { return travelInformation.getFuelConsumed(); }

    /**
     * Funkcja zwracaj�ca �redni� szybko��
     * @return
     */
    public int getAverageSpeed() { return travelInformation.getAverageSpeed(); }

    /**
     * Funkcja s�u��ca przyspieszaniu
     */
    public void accelerate(){
        speed.accelerate();
    }

    /**
     * Funkcja s�u��ca hamowaniu
     */
    public void brake(){
        speed.brake();
    }

    /**
     * Funkcja parsuj�ca szybko�� na string
     * @return
     */
    public String getSpeedAsString(){
        return speed.getSpeedAsString();
    }

    /**
     * 
     */
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
