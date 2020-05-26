package view;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

/**
 * Klasa, której grupa reprezentuje prawy kierunkowskaz.
 */
public class RightIndicatorLight {
    /**
     * group stanowi grupę wszystkich obiektów reprezentujących graficznie kontrolkę.
     * polygon to obiekt klasy Polygon reprezentujący grot strzałki kierunkowskazu.
     * line reprezentuje trzon strzałki kierunkowskazu.
     */

    private Group group = new Group();
    private Polygon polygon = new Polygon();
    private Line line = new Line();

    /**
     * W konstruktorze następuje wywołanie metod odpowiadających prawidłowa ustawienie atrybutów klasy oraz dodanie ich
     * do grupy.
     */
    RightIndicatorLight()  {
        createPolygon();
        createLine();
        group.getChildren().add(polygon);
        group.getChildren().add(line);
        BorderPane.setAlignment(group, Pos.CENTER);
    }

    /**
     * Tworzy wielokąt wchodzący w skład ikonki kierunkowskazu.
     */
    private void createPolygon(){
        Double[] points = {
                800.0, 50.0,
                700.0, 20.0,
                700.0, 80.0};
        polygon.getPoints().addAll(points);
        polygon.setFill(Color.BLACK);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), group);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
    }

    /**
     * Tworzy linię wchodzącą w skład ikonki kierunkowskazu.
     */
    private void createLine(){
        line.setStartX(600);
        line.setStartY(50);
        line.setEndX(700);
        line.setEndY(50);
        line.setStrokeWidth(10);
        line.setStroke(Color.BLACK);
    }
    /**
     * @return zwraca grupę reprezentującą kontrolkę.
     */
    public Group getGroup(){
        return group;
    }
    /**
     * Metoda odpowiadająca za pojawianie się kontrolki. W momencie jej wywołania wszystkie obiekty wchodzące w skład
     * kontrolki uzyskują barwę zieloną, co jest równoznaczne z uaktywnieniem kontrolki.
     */
    public void turnOn(){
        line.setStroke(Color.ORANGE);
        polygon.setFill(Color.ORANGE);
    }
    /**
     * Metoda odpowiadająca za znikanie kontrolki. W momencie jej wywołania zmienia wszystkie obiekty wchodzące w skład
     * kontrolki tak, aby ich kolor stał się czarny, przez co następuje dopasowanie się do sceny.
     */
    public void turnOff(){
        line.setStroke(Color.BLACK);
        polygon.setFill(Color.BLACK);
    }
}
