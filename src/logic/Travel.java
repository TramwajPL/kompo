package logic;

import java.util.Timer;

import data.SQLConnection;
import data.SQLParser;
import data.XMLParser;

/**
 * Klasa s³u¿¹ca do oblczania przebytej drogi
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
            	SQLConnection sql = new SQLConnection();
                SQLParser parser = new SQLParser();
                XMLParser parser2 = new XMLParser();
                parser.convert(travelInformation, sql);
                parser2.convert(travelInformation);
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
     * Funkcja zwracaj¹ca czas podró¿y
     * @return
     */
    public int getJourneyTime(){
        return travelInformation.getTotalTravelTime();
    }

    /**
     * Funkcja zwracaj¹ca ca³kowity pokonany dystans
     * @return
     */
    public double getTotalDistance(){
        return travelInformation.getTotalDistance();
    }

    /**
     * Funkcja zwracaj¹ca spalone paliwo
     * @return
     */
    public double getFuelConsumed() { return travelInformation.getFuelConsumed(); }

    /**
     * Funkcja zwracaj¹ca œredni¹ szybkoœæ
     * @return
     */
    public int getAverageSpeed() { return travelInformation.getAverageSpeed(); }

    /**
     * Funkcja s³u¿¹ca przyspieszaniu
     */
    public void accelerate(){
        speed.accelerate();
    }

    /**
     * Funkcja s³u¿¹ca hamowaniu
     */
    public void brake(){
        speed.brake();
    }

    /**
     * Funkcja parsuj¹ca szybkoœæ na string
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
