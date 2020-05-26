package view;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import logic.Travel;

/**
 * Klasa reprezentująca prędkościomierz. W jej skład wchodzą linie ustalające zakres prędkościomierza oraz igła
 * wskazująca na aktualną predkość.
 */

public class Speedometer {

    private Travel travel;
    private Line index = new Line();
    private Group speedometerGroup = new Group();

    /**
     * W konstruktorze następuję wywołanie metod odpowiedzialnych za utworzenie prędkościomierza.
     * @param t jest to parametr klasy Travel niezbędny do prawidłowego wskazywania prędkości przez
     *          igłę prędkościomierza.
     */
    Speedometer(Travel t) {
        travel = t;
        setIndex();
        setSpeedometer();
    }

    /**
     * Ustawienie odpowiednich parametrów igły.
     */
    private void setIndex() {
        index.setStartX(0);
        index.setStartY(0);
        index.setEndX(-200);
        index.setEndY(0);
        index.setStroke(Color.RED);
        index.setStrokeWidth(6);
    }

    /**
     * Dodawanie do grupy poszczególnych linii wchodzących w skład prędkościomierza wraz z adekwatnymi wartościami
     * prędkości oraz igły.
     */
    private void setSpeedometer(){
        speedometerGroup.getChildren().add(createArc());
        speedometerGroup.getChildren().add(createSpeedometerLine(-240,0,0,0)); //0km/h
        speedometerGroup.getChildren().add(createSpeedometerLine(-221,-71, -177,-58)); //20
        speedometerGroup.getChildren().add(createSpeedometerLabel(-173,-70,"20"));
        speedometerGroup.getChildren().add(createSpeedometerLine(-190,-138,-151,-109)); //40
        speedometerGroup.getChildren().add(createSpeedometerLabel(-151,-114,"40"));
        speedometerGroup.getChildren().add(createSpeedometerLine(-138,-190,-108,-151)); //60
        speedometerGroup.getChildren().add(createSpeedometerLabel(-108,-153,"60"));
        speedometerGroup.getChildren().add(createSpeedometerLine(-72,-222,-57,-177)); //80
        speedometerGroup.getChildren().add(createSpeedometerLabel(-66,-177,"80"));
        speedometerGroup.getChildren().add(createSpeedometerLine(0,-235,0,-185)); //100
        speedometerGroup.getChildren().add(createSpeedometerLabel(-20,-186,"100"));
        speedometerGroup.getChildren().add(createSpeedometerLine(72,-222,57,-177)); //120
        speedometerGroup.getChildren().add(createSpeedometerLabel(35,-177,"120"));
        speedometerGroup.getChildren().add(createSpeedometerLine(138,-190,108,-151)); //140
        speedometerGroup.getChildren().add(createSpeedometerLabel(77,-153,"140"));
        speedometerGroup.getChildren().add(createSpeedometerLine(190,-138,151,-109)); //160
        speedometerGroup.getChildren().add(createSpeedometerLabel(105,-114,"160"));
        speedometerGroup.getChildren().add(createSpeedometerLine(221,-71,177,-58)); //180
        speedometerGroup.getChildren().add(createSpeedometerLabel(130,-70,"180"));
        speedometerGroup.getChildren().add(createSpeedometerLine(240,0,0,0)); //200km/h
        speedometerGroup.getChildren().add(createSpeedometerLabel(-25,-120,"km/h")); //km/h label
        speedometerGroup.getChildren().add(index);
    }

    /**
     * Metoda pomocnicza ułatwiająca tworzenie wartości prędkości wchodzących w skład prędkościomierza.
     * @param translateX - przesunięcie tekstu na osi x.
     * @param translateY - przesunięcie tekstu na osi y.
     * @param text - zawartość tekstu.
     * @return zwraca biały Label o wyżej określonych parametrach.
     */
    private Label createSpeedometerLabel(int translateX, int translateY, String text){
        Label lab = new Label(text);
        lab.setTranslateX(translateX);
        lab.setTranslateY(translateY);
        lab.setFont(new Font("Verdana", 22));
        lab.setTextFill(Color.WHITE);
        return lab;
    }

    /**
     * Metoda pomocnicza umożliwiająca szybkie tworzenie linii pomocniczych wchodzących w skład prędkościomierza.
     * @param startX - pierwsza współrzędna x-owa.
     * @param startY - pierwsza współrzędna y-owa.
     * @param endX - druga współrzędna x-owa.
     * @param endY - druga współrzędna y-owa.
     * @return zwraca czerwoną linię o wprowadzonych parametrach.
     */
    private Line createSpeedometerLine(int startX, int startY, int endX, int endY){
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStroke(Color.RED);
        line.setStrokeWidth(4);
        return line;
    }

    /**
     * Tworzy łuk w kształcie półokrągu wchodzącego w skład prędkościomierza.
     * @return zwraca łuk o parametrach zdefiniowanych w ciele metody.
     */
    private Arc createArc(){
        Arc arc = new Arc();
        arc.setRadiusX(210);
        arc.setRadiusY(210);
        arc.setLength(180);
        arc.setStartAngle(0);
        arc.setFill(Color.BLACK);
        arc.setStroke(Color.RED);
        return arc;
    }

    /**
     * Metoda mająca za zadanie aktualizację położenia jednego końca igły. W zależności od prędkości pojazdu, igła
     * porusza sie po półokręgu wskazując aktualną prędkośc zgodnie z liniami prędkościomierza.
     */
    public void updateNeedle(){
        int maxSpeed = 200;
        Double diff = Double.parseDouble(travel.getSpeedAsString());
        diff /= maxSpeed;
        diff *= Math.PI;
        index.setEndX(-200 * Math.cos(diff));
        index.setEndY(-200 * Math.sin(diff));
    }

    /**
     * @return zwraca prędkościomierz jako grupę.
     */
    public Group getSpeedometerGroup(){
        return speedometerGroup;
    }

}
