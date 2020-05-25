package logic;

import data.SpeedContainer;
import logic.Speed;
import logic.TravelInformation;

/**
 * Klasa odpowiadaj�ca za przekazywanie odpowiednich szybko�ci do interfejsu konsolowego
 * @author wiktg
 *
 */
public class ConsoleController {
	private TravelInformation info;
	
	/**
	 * Bezparametrowy konstruktor klasy ConsoleInterfaceController
	 */
	public ConsoleController() {
		this.info = new TravelInformation();
	}
	
	/**
	 * Funkcja tworz�ca szybko�� na podstawie podanych parametr�w
	 * @param speed
	 * @param acceleration
	 * @param airResistance
	 */
	public void createTravelInformation(double totalDistance, double firstDailyOdometerValue, double secondDailyOdometerValue
			, int totalTravelTime, double singleTravelDistance, double fuelConsumed) {
		info.setTotalDistance(totalDistance);
		info.setFirstDailyOdometerValue(firstDailyOdometerValue);
		info.setSecondDailyOdometerValue(secondDailyOdometerValue);
		info.setTotalTravelTime(totalTravelTime);
		info.setSingleTravelDistance(singleTravelDistance);
		info.setFuelConsumed(fuelConsumed);
	}
	
	/**
	 * Funkcja wypisuj�ca wszystkie osi�gni�te szybko�ci
	 * @return
	 */
	public String showTravelInformation() {
		
		return info.toString();
	}
	
	/**
	 * Funkcja usuwuj�ca szybko�� na podstawie indeksu
	 * @param index
	 */
	public void deleteInformation() {
		info.setTotalDistance(0);
		info.setFirstDailyOdometerValue(0);
		info.setSecondDailyOdometerValue(0);
		info.setTotalTravelTime(0);
		info.setSingleTravelDistance(0);
		info.setFuelConsumed(0);
	}

}
