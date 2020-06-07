package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class Settings {
    private MenuBar menuBar = new MenuBar();

    Settings(){
        menuBar.getMenus().add(settings());

    }

    private Menu settings(){
        Menu menu = new Menu();
        menu.setText("Ustawienia");
        menu.getItems().add(aboutProgram());
        menu.getItems().add(changeLightsColor());
        return menu;
    }

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

    private MenuItem changeLightsColor(){
        RadioMenuItem choice1 = new RadioMenuItem();
       if(choice1.isSelected()){

       }
        choice1.setText("Tryb wy�wietlania");
        return choice1;
    }

    MenuBar getMenuBar(){
        return menuBar;
    }

}
