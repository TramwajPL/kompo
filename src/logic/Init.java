package logic;

import javafx.application.Application;
import view.Dashboard;

/**
 * Klasa przyjmująca argumenty i na ich podstawie włączająca
 * odpowiedni interfejs użytkownika
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
