package logic;

import java.util.ArrayList;

public class TravelInformation {

    private ArrayList<Integer> speeds = new ArrayList<>();

    //z bazki odczyt
    private double totalDistance = 0;
    private double firstDailyOdometerValue = 0;
    private double secondDailyOdometerValue = 0;
    private int totalTravelTime = 0;
    private final int minutesInHour = 60;

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

    public TravelInformation(){}

    public void calculateTotalDistance(int speed){
        double distance = speed * 1000;
        distance /= 3600;
        totalDistance += distance;
        firstDailyOdometerValue += distance;
        secondDailyOdometerValue += distance;
        speeds.add(speed);
        addSecondToTotalTime();
    }

    public void addSecondToTotalTime(){
        totalTravelTime += 1;
    }

    public int getTotalTravelTime() {
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
