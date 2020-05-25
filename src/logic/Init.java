package logic;

import javafx.application.Application;
import view.Dashboard;

/**
 * Klasa przyjmująca argumenty i na ich podstawie włączająca
 * odpowiedni interfejs użytkownika
 */
public class Init {

	/**
	 * Funkcja włączająca interfejs graficzny dla argumentu GUI
	 * oraz interfejs konsolowy dla argumentu CON.
	 * @param args
	 */
    Init(String[] args){
        if (args[0].equals("GUI")) {
            runGUI();
        }
        else if (args[0].equals("CON")) {
            runConsole();
        }
    }

    /**
     * Funkcja włączająca interfejs graficzny
     */
    private void runGUI(){
        Application.launch(Dashboard.class);
    }

    /**
     * Funkcja włączająca interfejs konsolowy
     */
    private void runConsole(){
        new ConsoleInterface();
    }

}
