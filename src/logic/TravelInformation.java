package logic;

import java.util.ArrayList;

/**
 * Klasa przechowuj�ca informacje na temat danej trasy
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
     * Funkcja zapisu informacji zawartych w klasie do stringu
     */
    @Override
	public String toString() {
		return "TravelInformation [totalDistance=" + totalDistance + ", firstDailyOdometerValue="
				+ firstDailyOdometerValue + ", secondDailyOdometerValue=" + secondDailyOdometerValue
				+ ", totalTravelTime=" + totalTravelTime + ", singleTravelDistance=" + singleTravelDistance
				+ ", fuelConsumed=" + fuelConsumed + "]";
	}

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

    /**
     * Funkcja zwracaj�ca warto�� pola singleTravelDistance
     * @return
     */
    public double getSingleTravelDistance() {
		return singleTravelDistance;
	}

    /**
     * Funkcja ustawiaj�ca warto�� pola speeds na podan� warto��
     * @param speeds
     */
	public void setSpeeds(ArrayList<Integer> speeds) {
		this.speeds = speeds;
	}

	/**
	 * Funkcja ustawiaj�ca warto�� pola totalDistance na podan� warto��
	 * @param totalDistance
	 */
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	/**
	 * Funkcja ustawiaj�ca warto�� pola totalTravelTime na podan� warto��
	 * @param totalTravelTime
	 */
	public void setTotalTravelTime(int totalTravelTime) {
		this.totalTravelTime = totalTravelTime;
	}

	/**
	 * Funkcja ustawiaj�ca warto�� pola singleTravelDistance na podan� warto��
	 * @param singleTravelDistance
	 */
	public void setSingleTravelDistance(double singleTravelDistance) {
		this.singleTravelDistance = singleTravelDistance;
	}

	/**
	 * Funkcja ustawiaj�ca warto�� pola fuelConsumed na podan� warto��
	 * @param fuelConsumed
	 */
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
     * Funkcja obliczaj�ca zuzycie paliwa na 100 km
     */
    public void consumeFuel(){
        final double fuelConsumptionPer100Km = 8;
        fuelConsumed = singleTravelDistance / fuelConsumptionPer100Km;
    }

    /**
     * Funkcja zwracaj�ca ilo�� zu�ytego paliwa
     * @return fuelConsumed
     */
    public double getFuelConsumed(){
        return fuelConsumed;
    }

    /**
     * Funkcja przeliczaj�ca szybko�� na km/h
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
     * Funkcja aktualizuj�ca szybko�� na podtsawie podanego parametru
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
     * Funkcja dodaj�ca sekunde do ca�kowitego czasu
     */
    public void addSecondToTotalTime(){
        totalTravelTime += 1;
    }

    /**
     * Funkcja zwracaj�ca ca�kowity czas po�wi�cony na podr�
     * @return
     */
    public int getTotalTravelTime() {
        int minutesInHour = 60;
        return totalTravelTime/minutesInHour;
    }

    /**
     * Funkcja zwracaj�ca �redni� pr�dko��
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
     * Funkcja zwracaj�ca ca�kowity pokonany dystans
     * @return
     */
    public double getTotalDistance() {
        return totalDistance;
    }

    /**
     * Funkcja zwracaj�ca szybko�� w formie stringu
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
