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
    ConsoleInterface(){
    	this.controller = new ConsoleController();
    	this.reader = new BufferedReader(new InputStreamReader(System.in));
        run();
        while (choice.compareTo("0") != 0) {
        	if (choice.compareTo("0") == 0) {
        		
        	}
        	else if(choice.compareTo("1") == 0) {
        		System.out.println(controller.showTravelInformation());
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
		        	System.out.print("Podaj : ");
		        	indexString2 = reader.readLine();
		        	firstDailyOdometerValue = Double.parseDouble(indexString2);
		        	System.out.print("Podaj : ");
		        	indexString3 = reader.readLine();
		        	secondDailyOdometerValue = Double.parseDouble(indexString3);
		        	System.out.print("Podaj ca�kowity czas podr�y ");
		        	indexString4 = reader.readLine();
		        	totalTravelTime = Integer.parseInt(indexString4);
		        	System.out.print("Podaj pojedyncza odleg�o��: ");
		        	indexString5 = reader.readLine();
		        	singleTravelDistance = Double.parseDouble(indexString5);
		        	System.out.print("Podaj spalone paliwo: ");
		        	indexString6 = reader.readLine();
		        	fuelConsumed = Double.parseDouble(indexString6);
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
		        	System.out.print("Podaj index: ");
		        	indexString = reader.readLine();	
		        	int index = Integer.parseInt(indexString);
		        	controller.deleteInformation();
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
		System.out.println("3. Usu� dane");
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
