package logic;

import data.SpeedContainer;
import logic.Speed;
import logic.TravelInformation;

/**
 * Klasa odpowiadająca za przekazywanie odpowiednich szybkości do interfejsu konsolowego
 * @author wiktg
 *
 */
public class ConsoleController {
	
	/**
	 * Bezparametrowy konstruktor klasy ConsoleInterfaceController
	 */
	public ConsoleController() {
	}
	
	/**
	 * Funkcja tworząca szybkość na podstawie podanych parametrów
	 * @param speed
	 * @param acceleration
	 * @param airResistance
	 */
	public void createTravelInformation(double totalDistance, double firstDailyOdometerValue, double secondDailyOdometerValue
			, int totalTravelTime, double singleTravelDistance, double fuelConsumed, TravelInformation info) {
		info.setTotalDistance(totalDistance);
		info.setFirstDailyOdometerValue(firstDailyOdometerValue);
		info.setSecondDailyOdometerValue(secondDailyOdometerValue);
		info.setTotalTravelTime(totalTravelTime);
		info.setSingleTravelDistance(singleTravelDistance);
		info.setFuelConsumed(fuelConsumed);
	}
	
	/**
	 * Funkcja wypisująca wszystkie osiągnięte szybkości
	 * @return
	 */
	public String showTravelInformation(TravelInformation info) {
		
		return info.toString();
	}
	
	/**
	 * Funkcja usuwująca szybkość na podstawie indeksu
	 * @param index
	 */
	public void deleteInformation(TravelInformation info) {
		info.setTotalDistance(0);
		info.setFirstDailyOdometerValue(0);
		info.setSecondDailyOdometerValue(0);
		info.setTotalTravelTime(0);
		info.setSingleTravelDistance(0);
		info.setFuelConsumed(0);
	}

}
