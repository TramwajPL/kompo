package view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Travel;

import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;

/**
 * Klasa przedstawiająca wszystkie informację na temat podróży. Stanowi ona dolny panel interfejsu graficznego.
 */


public class TravelInformationPanel {
    /**
     * speedLabel - odpowiaada za wyświetlanie aktualnej wartości prędkości.
     * totalOdometerLabel - odpowiada za wyświetlanie aktualnej wartości przejechanych kilometrów. Inaczej mówiąc
     * wyświetla całkowity przebieg pojazdu.
     * firstDailyOdometerLabel - pierwszy licznik przebiegu dziennego.
     * secondDailyOdometerLabel - drugi licznik przebiegu dziennego.
     * journeyTimeLabel - pokazuje całkowity czas podróży.
     * fuelConsumedLabel - pokazuje ilość zużytego paliwa.
     * averageSpeedLabel = pokazuje średnią prędkość.
     * group - grupa zawierająca wszystkie wymienione wyżej atrybuty.
     */
    private Travel travel;
    private Label speedLabel = new Label("0");
    private Label totalOdometerLabel = new Label("0");
    private Label firstDailyOdometerLabel = new Label("0");
    private Label secondDailyOdometerLabel = new Label("0");
    private Label journeyTimeLabel = new Label("0");
    private Label fuelConsumedLabel = new Label("0");
    private Label averageSpeedLabel = new Label("0");
    private Group group = new Group();

    /**
     * W konstruktorze zachodzi wywołanie wszystkich metod odpowiedzialnych za ustawienie odpowiednich parametrów
     * wszystkich atrybutów klasy oraz dodanie ich do grupy. Oprócz tego, wprowadzana jest centralna orientacja grupy
     * względem innych obiektów.
     * @param t
     */
    TravelInformationPanel(Travel t){
        travel = t;
        setSpeedLabel();
        setTotalOdometerLabel();
        setFirstDailyOdometerLabel();
        setSecondDailyOdometerLabel();
        setJourneyTimeLabel();
        setAverageSpeedLabel();
        setFuelConsumedLabel();
        group.getChildren().add(speedLabel);
        group.getChildren().add(totalOdometerLabel);
        group.getChildren().add(firstDailyOdometerLabel);
        group.getChildren().add(secondDailyOdometerLabel);
        group.getChildren().add(journeyTimeLabel);
        group.getChildren().add(fuelConsumedLabel);
        group.getChildren().add(averageSpeedLabel);
        BorderPane.setAlignment(group, Pos.CENTER);
        group.setNodeOrientation(RIGHT_TO_LEFT);
    }

    /**
     * @return zwraca grupę w postaci całego panelu informacyjnego.
     */
    Group getGroup(){
        return group;
    }

    /**
     * Odpowiada za ustawianie szczegółów wyświatlania tekstu odpowiadającego za ilość spalonego paliwa.
     */
    private void setFuelConsumedLabel(){
        fuelConsumedLabel.setLayoutX(5);
        fuelConsumedLabel.setLayoutY(0);
        fuelConsumedLabel.setFont(new Font("Verdana", 25));
        fuelConsumedLabel.setTextFill(Color.YELLOW);
    }
    /**
     * Odpowiada za ustawianie szczegółów wyświatlania tekstu odpowiadającego za średnią predkość.
     */
    private void setAverageSpeedLabel(){
        averageSpeedLabel.setLayoutX(5);
        averageSpeedLabel.setLayoutY(25);
        averageSpeedLabel.setFont(new Font("Verdana", 25));
        averageSpeedLabel.setTextFill(Color.RED);
    }

    /**
     * Odpowiada za ustawianie szczegółów wyświatlania tekstu odpowiadającego za czas podróży.
     */
    private void setJourneyTimeLabel(){
        journeyTimeLabel.setLayoutX(5);
        journeyTimeLabel.setLayoutY(50);
        journeyTimeLabel.setFont(new Font("Verdana", 25));
        journeyTimeLabel.setTextFill(Color.GREEN);
    }
    /**
     * Odpowiada za ustawianie szczegółów wyświatlania tekstu odpowiadającego za pokazywanie prędkości.
     */
    private void setSpeedLabel() {
        speedLabel.setFont(new Font("Arial", 100));
        speedLabel.setLayoutX(160);
        speedLabel.setLayoutY(0);
        speedLabel.setTextFill(Color.WHITE);
    }
    /**
     * Odpowiada za ustawianie szczegółów wyświatlania tekstu odpowiadającego za pokazywanie stanu całkowitego przebiegu.
     */
    private void setTotalOdometerLabel(){
        totalOdometerLabel.setLayoutX(160);
        totalOdometerLabel.setLayoutY(-40);
        totalOdometerLabel.setFont(new Font("Verdana", 40));
        totalOdometerLabel.setTextFill(Color.WHITE);
    }
    /**
     * Odpowiada za ustawianie szczegółów wyświatlania tekstu odpowiadającego za pokazywanie stanu pierwszego licznika
     * przebiegu dziennego.
     */
    private void setFirstDailyOdometerLabel() {
        firstDailyOdometerLabel.setLayoutX(350);
        firstDailyOdometerLabel.setLayoutY(20);
        firstDailyOdometerLabel.setFont(new Font("Verdana", 25));
        firstDailyOdometerLabel.setTextFill(Color.WHITE);
        firstDailyOdometerLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent me){
                travel.resetFirstOdometer();
            };
        });
    }
    /**
     * Odpowiada za ustawianie szczegółów wyświatlania tekstu odpowiadającego za pokazywanie stanu drugiego licznika
     * przebiegu dziennego.
     */
    private void setSecondDailyOdometerLabel() {
        secondDailyOdometerLabel.setLayoutX(350);
        secondDailyOdometerLabel.setLayoutY(60);
        secondDailyOdometerLabel.setFont(new Font("Verdana", 25));
        secondDailyOdometerLabel.setTextFill(Color.WHITE);
        secondDailyOdometerLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent me){
                travel.resetSecondOdometer();
            };
        });
    }

    /**
     * Metoda aktualizująca zawartość tekstu pokazującego prędkość.
     */
    void updateSpeedLabel(){
        speedLabel.setText(travel.getSpeedAsString());
    }
    /**
     * Metoda aktualizująca zawartość tekstu pokazującego przebieg całkowity.
     */
    void updateTotalOdometerLabel(){
        double temp = parseNumber(travel.getTotalDistance());
        totalOdometerLabel.setText(String.valueOf(temp));
    }
    /**
     * Metoda aktualizująca zawartość tekstu pokazującego stan pierwszego licznika przebiegu dziennego.
     */
    void updateFirstDailyOdometerLabel(){
        double temp = parseNumber(travel.getFirstOdometerValue());
        firstDailyOdometerLabel.setText(String.valueOf(temp));
    }
    /**
     * Metoda aktualizująca zawartość tekstu pokazującego stan drugiego licznika przebiegu dziennego.
     */
    void updateSecondDailyOdometerLabel(){
        double temp = parseNumber(travel.getSecondOdometerValue());
        secondDailyOdometerLabel.setText(String.valueOf(temp));
    }

    /**
     * Metoda aktualizująca zawartość tekstu pokazującego czas podróży.
     */
    void updateJourneyTimeLabel(){
        journeyTimeLabel.setText(String.valueOf(travel.getJourneyTime()) + "min");
    }
    /**
     * Metoda aktualizująca zawartość tekstu pokazującego ilość spalonego paliwa.
     */
    void updateFuelConsumedLabel(){
        double temp = parseNumber(travel.getFuelConsumed());
        fuelConsumedLabel.setText(String.valueOf(temp) + "l");
    }
    /**
     * Metoda aktualizująca zawartość tekstu pokazującego średnią prędkość.
     */
    void updateAverageSpeed(){
        averageSpeedLabel.setText(String.valueOf(travel.getAverageSpeed()) + "km/h");
    }

    /**
     * Metoda parsująca zmienną typu double tak, aby zawierała tylko jedną liczbę po przecinku.
     * @param number - pokonany dystans w metrach.
     * @return pokonany dystans w kilometrach z dokładnością do jednego miejsca po przecinku.
     */
    private double parseNumber(double number){
        double temp1 = (int)number;
        temp1 /= 100;
        double temp2 = (int)temp1;
        temp2 /= 10;
        return temp2;
    }

}
