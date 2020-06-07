package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

/**
 * Klasa reprezentuj�ca panel ustawienia.
 */

public class Settings {

    private MenuBar menuBar = new MenuBar();
    /**
     * W konstruktorze nast�puje dodanie zak�adaki Ustawienia do panelu ustawie�.
     */
    Settings(){
        menuBar.getMenus().add(settings());
    }

    /**
     * Utworzenie i dodanie obiektu klasy Menu reprezentuj�ca ustawienia.
     * @return
     */
    private Menu settings(){
        Menu menu = new Menu();
        menu.setText("Ustawienia");
        menu.getItems().add(aboutProgram());
        return menu;
    }

    /**
     * Metoda odpowiedzialna za utworzenie i zwr�cenie obiektu klasy menuItem reprezentuj�cym zak�adk� 'o programie'.
     * @return
     */
    private MenuItem aboutProgram(){
        MenuItem menuItem = new MenuItem();
        menuItem.setText("O programie");
        menuItem.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent ae){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("O programie");
                alert.setHeaderText("Program symuluj�cy zachowanie deski rozdzielczej samochodu");
                alert.setContentText("Sterowanie: \n A - �wiat�a drogowe \n S - �wiat�a mijania \n D - �wiat�a pozycyjne" +
                        "\n F - �wiat�o przeciwmgielne tylne \n G - �wiat�o przeciwmgielne przednie \n T - tempomat \n " +
                        "strza�ka w g�r� - przyspieszenie \n strza�ka w d� - hamowanie \n strza�ka w lewo - lewy kierunkowskaz" +
                        "\n strza�ka w prawo - prawy kierunkowskaz" );
                alert.show();
            };
        });
        return menuItem;
    }

    /**
     * Zwr�cenie ca�ego panelu ustawie�.
     * @return
     */
    MenuBar getMenuBar(){
        return menuBar;
    }

}
