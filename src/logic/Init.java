package logic;

import javafx.application.Application;
import view.Dashboard;

/**
 * Klasa przyjmuj¹ca argumenty i na ich podstawie w³¹czaj¹ca
 * odpowiedni interfejs u¿ytkownika
 */
public class Init {

	/**
	 * Funkcja w³¹czaj¹ca interfejs graficzny dla argumentu GUI
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
     * Funkcja w³¹czaj¹ca interfejs graficzny
     */
    private void runGUI(){
        Application.launch(Dashboard.class);
    }

    /**
     * Funkcja w³¹czaj¹ca interfejs konsolowy
     */
    private void runConsole(){
        new ConsoleInterface();
    }

}
