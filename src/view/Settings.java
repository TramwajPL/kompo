package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

/**
 * Klasa reprezentuj¹ca panel ustawienia.
 */

public class Settings {

    private MenuBar menuBar = new MenuBar();
    /**
     * W konstruktorze nastêpuje dodanie zak³adaki Ustawienia do panelu ustawieñ.
     */
    Settings(){
        menuBar.getMenus().add(settings());
    }

    /**
     * Utworzenie i dodanie obiektu klasy Menu reprezentuj¹ca ustawienia.
     * @return
     */
    private Menu settings(){
        Menu menu = new Menu();
        menu.setText("Ustawienia");
        menu.getItems().add(aboutProgram());
        return menu;
    }

    /**
     * Metoda odpowiedzialna za utworzenie i zwrócenie obiektu klasy menuItem reprezentuj¹cym zak³adkê 'o programie'.
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
                alert.setHeaderText("Program symuluj¹cy zachowanie deski rozdzielczej samochodu");
                alert.setContentText("Sterowanie: \n A - œwiat³a drogowe \n S - œwiat³a mijania \n D - œwiat³a pozycyjne" +
                        "\n F - œwiat³o przeciwmgielne tylne \n G - œwiat³o przeciwmgielne przednie \n T - tempomat \n " +
                        "strza³ka w górê - przyspieszenie \n strza³ka w dó³ - hamowanie \n strza³ka w lewo - lewy kierunkowskaz" +
                        "\n strza³ka w prawo - prawy kierunkowskaz" );
                alert.show();
            };
        });
        return menuItem;
    }

    /**
     * Zwrócenie ca³ego panelu ustawieñ.
     * @return
     */
    MenuBar getMenuBar(){
        return menuBar;
    }

}
