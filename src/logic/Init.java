package logic;

import javafx.application.Application;
import view.Dashboard;

/**
 * Klasa przyjmuj�ca argumenty i na ich podstawie w��czaj�ca
 * odpowiedni interfejs u�ytkownika
 */
public class Init {

    Init(String[] args){
        if (args[0].equals("GUI")) {
            runGUI();
        }
        else if (args[0].equals("CON")) {
            runConsole();
        }
    }

    private void runGUI(){
        Application.launch(Dashboard.class);
    }

    private void runConsole(){
        new ConsoleInterface();
    }

}
