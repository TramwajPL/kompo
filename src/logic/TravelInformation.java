package logic;

import java.util.ArrayList;

/**
 * Klasa przechowująca informacje na temat danej trasy
 */
public class TravelInformation {

    private ArrayList<Integer> speeds = new ArrayList<>();

    //z bazki odczyt
    private double totalDistance = 0;
    private double firstDailyOdometerValue = 0;
    private double secondDailyOdometerValue = 0;
    private int totalTravelTime = 0;
    private double singleTravelDistance = 0;
    private double fuelConsumed = 0;

    /**
     * Bezparametrowy konstruktor klasy TravelInformation
     */
    public TravelInformation(){}

    /**
     * 
     * @return
     */
    public double getFirstDailyOdometerValue() {
        return firstDailyOdometerValue;
    }

    /**
     * 
     * @return
     */
    public void setFirstDailyOdometerValue(double firstDailyOdometerValue) {
        this.firstDailyOdometerValue = firstDailyOdometerValue;
    }

    public double getSingleTravelDistance() {
		return singleTravelDistance;
	}

	public void setSpeeds(ArrayList<Integer> speeds) {
		this.speeds = speeds;
	}

	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public void setTotalTravelTime(int totalTravelTime) {
		this.totalTravelTime = totalTravelTime;
	}

	public void setSingleTravelDistance(double singleTravelDistance) {
		this.singleTravelDistance = singleTravelDistance;
	}

	public void setFuelConsumed(double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}

	/**
     * 
     * @return
     */
    public double getSecondDailyOdometerValue() {
        return secondDailyOdometerValue;
    }

    /**
     * 
     * @return
     */
    public void setSecondDailyOdometerValue(double secondDailyOdometerValue) {
        this.secondDailyOdometerValue = secondDailyOdometerValue;
    }

    /**
     * Funkcja obliczająca zuzycie paliwa na 100 km
     */
    public void consumeFuel(){
        final double fuelConsumptionPer100Km = 8;
        fuelConsumed = singleTravelDistance / fuelConsumptionPer100Km;
    }

    /**
     * Funkcja zwracająca ilość zużytego paliwa
     * @return fuelConsumed
     */
    public double getFuelConsumed(){
        return fuelConsumed;
    }

    /**
     * Funkcja przeliczająca szybkość na km/h
     * @param meters
     * @return distance
     */
    public double convertToKmPerHour(int meters){
        int metersInKilometer = 1000;
        int secondsInHour = 3600;
        double distance = meters * metersInKilometer;
        distance /= secondsInHour;
        return distance;
    }

    /**
     * Funkcja aktualizująca szybkość na podtsawie podanego parametru
     * @param speed
     */
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

    /**
     * Funkcja dodająca sekunde do całkowitego czasu
     */
    public void addSecondToTotalTime(){
        totalTravelTime += 1;
    }

    /**
     * Funkcja zwracająca całkowity czas poświęcony na podróż
     * @return
     */
    public int getTotalTravelTime() {
        int minutesInHour = 60;
        return totalTravelTime/minutesInHour;
    }

    /**
     * Funkcja zwracająca średnią prędkość
     * @return averageSpeed
     */
    public int getAverageSpeed(){
        int averageSpeed = 0;
        for(int i=0; i<speeds.size(); i++){
            averageSpeed += speeds.get(i);
        }
        averageSpeed /= speeds.size();
        return averageSpeed;
    }

    /**
     * Funkcja zwracająca całkowity pokonany dystans
     * @return
     */
    public double getTotalDistance() {
        return totalDistance;
    }

    /**
     * Funkcja zwracająca szybkość w formie stringu
     * @return s
     */
    public String toStringSpeeds() {
        String s = "";
        for(Integer i: speeds){
            s += speeds + "\n";
        }
        return s;
    }
}
