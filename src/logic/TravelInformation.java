package logic;

import java.util.ArrayList;

public class TravelInformation {

    private ArrayList<Integer> speeds = new ArrayList<>();

    //z bazki odczyt
    private double totalDistance = 0;
    private double firstDailyOdometerValue = 0;
    private double secondDailyOdometerValue = 0;
    private int totalTravelTime = 0;
    private double singleTravelDistance = 0;
    private double fuelConsumed = 0;

    public TravelInformation(){}

    public double getFirstDailyOdometerValue() {
        return firstDailyOdometerValue;
    }

    public void setFirstDailyOdometerValue(double firstDailyOdometerValue) {
        this.firstDailyOdometerValue = firstDailyOdometerValue;
    }

    public double getSecondDailyOdometerValue() {
        return secondDailyOdometerValue;
    }

    public void setSecondDailyOdometerValue(double secondDailyOdometerValue) {
        this.secondDailyOdometerValue = secondDailyOdometerValue;
    }

    public void consumeFuel(){
        final double fuelConsumptionPer100Km = 8;
        fuelConsumed = singleTravelDistance / fuelConsumptionPer100Km;
    }


    public double getFuelConsumed(){
        return fuelConsumed;
    }

    public double convertToKmPerHour(int meters){
        int metersInKilometer = 1000;
        int secondsInHour = 3600;
        double distance = meters * metersInKilometer;
        distance /= secondsInHour;
        return distance;
    }

    public void updateDistance(int speed){
        double distance = convertToKmPerHour(speed);
        totalDistance += distance;
        firstDailyOdometerValue += distance;
        secondDailyOdometerValue += distance;
        singleTravelDistance += distance;
        speeds.add(speed);
        consumeFuel();
        addSecondToTotalTime();
    }

    public void addSecondToTotalTime(){
        totalTravelTime += 1;
    }

    public int getTotalTravelTime() {
        int minutesInHour = 60;
        return totalTravelTime/minutesInHour;
    }

    public int getAverageSpeed(){
        int averageSpeed = 0;
        for(int i=0; i<speeds.size(); i++){
            averageSpeed += speeds.get(i);
        }
        averageSpeed /= speeds.size();
        return averageSpeed;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public String toStringSpeeds() {
        String s = "";
        for(Integer i: speeds){
            s += speeds + "\n";
        }
        return s;
    }
}
