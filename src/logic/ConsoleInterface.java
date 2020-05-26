package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Klasa S�u��ca do obs�ugi interfejsu konsoli przez u�ytkownika
 */
public class ConsoleInterface {

    private Travel travel = new Travel();
    private String choice = null;
	private BufferedReader reader;
	private ConsoleController controller;
	
	/**
	 * Bezparametrowy konstruktor z p�tl� kt�ra ko�czy dzia�anie, je�li u�ytkownik wybierze jedn� z opcji,
	 * pozwalaj�ca na dodanie szybko�ci i usuniecie jej
	 */
    ConsoleInterface() throws ChoiceNotAvailableException{
    	this.controller = new ConsoleController();
    	this.reader = new BufferedReader(new InputStreamReader(System.in));
        run();
        travel.getSpeed().setACC_MULTIPLIER(0.2);
        travel.getSpeed().setBRAKE_MULTIPLIER(1);
        travel.getSpeed().setAirResistance(0);
        while (choice.compareTo("0") != 0) {
        	//if (choice.compareTo("1") != 0 || choice.compareTo("2") != 0 || choice.compareTo("3") != 0 || choice.compareTo("4") != 0 || choice.compareTo("5") != 0)
        		//throw new ChoiceNotAvailableException();
        	if (choice.compareTo("0") == 0) {
        		
        	}
        	else if(choice.compareTo("1") == 0) {
        		System.out.println(controller.showTravelInformation(travel.getTravelInformation()));
        		try {
        			reader.readLine();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        	else if (choice.compareTo("2") == 0) {
        		String indexString = null;
        		String indexString2 = null;
        		String indexString3 = null;
        		String indexString4 = null;
        		String indexString5 = null;
        		String indexString6 = null;
        		double totalDistance;
        		double firstDailyOdometerValue;
        		double secondDailyOdometerValue;
        		int totalTravelTime;
        		double singleTravelDistance;
        		double fuelConsumed;
        		try {
        			System.out.print("Podaj pokonany dystans: ");
        			indexString = reader.readLine();
        			totalDistance = Double.parseDouble(indexString);
        			travel.getTravelInformation().setTotalDistance(totalDistance);
		        	System.out.print("Podaj : ");
		        	indexString2 = reader.readLine();
		        	firstDailyOdometerValue = Double.parseDouble(indexString2);
		        	travel.getTravelInformation().setFirstDailyOdometerValue(firstDailyOdometerValue);;
		        	System.out.print("Podaj : ");
		        	indexString3 = reader.readLine();
		        	secondDailyOdometerValue = Double.parseDouble(indexString3);
		        	travel.getTravelInformation().setSecondDailyOdometerValue(secondDailyOdometerValue);;
		        	System.out.print("Podaj ca�kowity czas podr�y ");
		        	indexString4 = reader.readLine();
		        	totalTravelTime = Integer.parseInt(indexString4);
		        	travel.getTravelInformation().setTotalTravelTime(totalTravelTime);;
		        	System.out.print("Podaj pojedyncza odleg�o��: ");
		        	indexString5 = reader.readLine();
		        	singleTravelDistance = Double.parseDouble(indexString5);
		        	travel.getTravelInformation().setSingleTravelDistance(singleTravelDistance);;
		        	System.out.print("Podaj spalone paliwo: ");
		        	indexString6 = reader.readLine();
		        	fuelConsumed = Double.parseDouble(indexString6);
		        	travel.getTravelInformation().setFuelConsumed(fuelConsumed);;
		        	System.out.print("Sukces!");
		        	reader.readLine();
		            run();
        		} catch (IOException  e) {		            
		        	System.out.println("Podano nieprawid�owe dane");
		        } 
        	}
        	else if (choice.compareTo("3") == 0) {
        		String indexString = null;
        		try {
		        	System.out.print("Usu� dane");
		        	controller.deleteInformation(travel.getTravelInformation());
			        System.out.print("Sukces!");
		        } catch (Exception  e) {		            
		        	System.out.println("Podano nieprawid�owe dane");
		        } 
		        finally {
		        	try {
						reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            run();
		        }
        	}
        	else if (choice.compareTo("4") == 0) {
        		travel.getSpeed().setAcceleration(5);
        		travel.accelerate();
        		System.out.print("Twoja aktualna pr�dko�� to:");
        		System.out.print(travel.getSpeedAsString());
        		
        	}
        	else if (choice.compareTo("5") == 0) {
        		travel.brake();
        		System.out.print("Twoja aktualna pr�dko�� to:");
        		System.out.print(travel.getSpeedAsString());
        	}
        	run();
        }
    }

    /**
     * Funkcja wy�wietlaj�ca w konsoli mo�liwo�ci jakie ma u�ytkownik i zapisuj�ca je do zmiennej choice
     */
    private void run(){
    	System.out.println("Witaj w desce rozdzielczej!");
		System.out.println("Co chcesz zrobi�");
		System.out.println("1. Wy�wietl informacje na temat podr�y");
		System.out.println("2. Dodaj informacje");
		System.out.println("3. Usu� informacje");
		System.out.println("4. Dodaj pr�dko��");
		System.out.println("5. Hamuj");
		System.out.println("0. Zamknij deske");
		System.out.println();
        System.out.print("Tw�j wyb�r: ");
		try {
        	choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
