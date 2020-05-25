package logic;

import data.SpeedContainer;
import logic.Speed;
import logic.TravelInformation;

/**
 * Klasa odpowiadaj¹ca za przekazywanie odpowiednich szybkoœci do interfejsu konsolowego
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
	 * Funkcja tworz¹ca szybkoœæ na podstawie podanych parametrów
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
	 * Funkcja wypisuj¹ca wszystkie osi¹gniête szybkoœci
	 * @return
	 */
	public String showTravelInformation(TravelInformation info) {
		
		return info.toString();
	}
	
	/**
	 * Funkcja usuwuj¹ca szybkoœæ na podstawie indeksu
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
