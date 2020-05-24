package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import view.ConsoleInterfaceController;

public class ConsoleInterface {

    private Travel travel = new Travel();
    private String choice = null;
	private BufferedReader reader;
	private ConsoleInterfaceController controller;

    ConsoleInterface(){
    	this.controller = new ConsoleInterfaceController();
    	this.reader = new BufferedReader(new InputStreamReader(System.in));
        run();
        while (choice.compareTo("0") != 0) {
        	if (choice.compareTo("0") == 0) {
        		
        	}
        	else if(choice.compareTo("1") == 0) {
        		System.out.println(controller.showSpeeds());
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
        		double speed;
        		double acceleration;
        		double airResistance;
        		try {
        			System.out.print("Podaj szybkoœæ: ");
        			indexString = reader.readLine();
        			speed = Double.parseDouble(indexString);
		        	System.out.print("Podaj przyspieszenie: ");
		        	indexString2 = reader.readLine();
		        	acceleration = Double.parseDouble(indexString2);
		        	System.out.print("Podaj opór powietrza: ");
		        	indexString3 = reader.readLine();
		        	airResistance = Double.parseDouble(indexString3);
		        	controller.createSpeed(speed, acceleration, airResistance);
		        	System.out.print("Sukces!");
		        	reader.readLine();
		            run();
        		} catch (IOException  e) {		            
		        	System.out.println("Podano nieprawid³owe dane");
		        } 
        	}
        	else if (choice.compareTo("3") == 0) {
        		String indexString = null;
        		try {
		        	System.out.print("Podaj index: ");
		        	indexString = reader.readLine();	
		        	int index = Integer.parseInt(indexString);
		        	controller.deleteSpeed(index);
			        System.out.print("Sukces!");
		        } catch (Exception  e) {		            
		        	System.out.println("Podano nieprawid³owe dane");
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

    private void run(){
    	System.out.println("Witaj w desce rozdzielczej!");
		System.out.println("Co chcesz zrobiæ");
		System.out.println("1. Wyœwietl osiagniete predkosci");
		System.out.println("2. Dodaj predkosc");
		System.out.println("3. Usuñ predkosc");
		System.out.println("0. Zamknij deske");
		System.out.println();
        System.out.print("Twój wybór: ");
		try {
        	choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
