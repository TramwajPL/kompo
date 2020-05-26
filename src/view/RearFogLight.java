package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca ikonkę tylnych świateł przeciwmgielnych.
 */

public class RearFogLight implements Light {

    /**
     * group stanowi grupę wszystkich obiektów reprezentujących graficznie kontrolkę.
     * lines zawiera wszystkie linie przedstawiające światła.
     * curves zawiera zakrzywione linie przedstawiające reflektor.
     */
    private Group group = new Group();
    private List<Line> lines = new ArrayList<>();
    private List<CubicCurve> curves = new ArrayList<>();

    /**
     * Metoda odpowiadająca za znikanie kontrolki. W momencie jej wywołania zmienia wszystkie obiekty wchodzące w skład
     * kontrolki tak, aby ich kolor stał się czarny, przez co następuje dopasowanie się do sceny.
     */
    @Override
    public void turnOff() {
        for(Line line: lines){
            line.setStroke(Color.BLACK);
        }
        for(CubicCurve cc: curves){
            cc.setStroke(Color.BLACK);
        }
    }
    /**
     * Metoda odpowiadająca za pojawianie się kontrolki. W momencie jej wywołania wszystkie obiekty wchodzące w skład
     * kontrolki uzyskują barwę żółtą, co jest równoznaczne z uaktywnieniem kontrolki.
     */
    @Override
    public void turnOn() {
        for(Line line: lines){
            line.setStroke(Color.YELLOW);
        }
        for(CubicCurve cc: curves){
            cc.setStroke(Color.YELLOW);
        }
    }
    /**
     * W konstruktorze następuje dodanie obiektów do grupy oraz odpowiednie przesunięcie na osi x i obrót o 180 stopni.
     */
    RearFogLight(){
        group.getChildren().add(createFogLine());
        group.getChildren().add(getHeadlight());
        group.getChildren().add(getLines());
        group.setLayoutX(650);
        group.setRotate(180);
    }

    /**
     * Tworzy i zwraca grupę reprezentującą reflektor.
     * @return zwraca grupę reprezentującą reflektor.
     */
    @Override
    public Group getHeadlight() {
        Group group = new Group();
        CubicCurve cc1 = new CubicCurve();
        cc1.setStartX(70);
        cc1.setStartY(0);
        cc1.setEndX(70);
        cc1.setEndY(100);
        cc1.setControlX1(150);
        cc1.setControlY1(0);
        cc1.setControlX2(150);
        cc1.setControlY2(100);
        cc1.setStroke(Color.BLACK);
        cc1.setFill(Color.BLACK);
        cc1.setStrokeWidth(10);

        CubicCurve cc2 = new CubicCurve();
        cc2.setStartX(70);
        cc2.setStartY(0);
        cc2.setEndX(70);
        cc2.setEndY(100);
        cc2.setControlX1(60);
        cc2.setControlY1(20);
        cc2.setControlX2(60);
        cc2.setControlY2(80);
        cc2.setFill(Color.BLACK);
        cc2.setStroke(Color.BLACK);
        cc2.setStrokeWidth(10);

        curves.add(cc1);
        curves.add(cc2);
        group.getChildren().add(cc1);
        group.getChildren().add(cc2);
        group.setLayoutX(40);

        return group;
    }

    /**
     * @return zwraca grupę linii świateł wchodzących w skład kontrolki.
     */
    @Override
    public Group getLines() {
        Group group = new Group();
        for(int i=0; i<101; i+=50 )
            group.getChildren().add(createLine(0,i,80,i));
        return group;
    }
    /**
     * Metoda pomocnicza do tworzenia lini świateł.
     * @param startX początkowa współrzędna x-owa linii.
     * @param startY początkowa współrzędna y-owa linii.
     * @param endX końcowa współrzędna x-owa linii.
     * @param endY końcowa współrzędna y-owa linii.
     * @return zwraca obiekty klasy Line reprezentujący pojjedynczą linię światłą.
     */
    @Override
    public Line createLine(int startX, int startY, int endX, int endY) {
        Line line = new Line();
        line.setStrokeWidth(10);
        line.setStroke(Color.BLACK);
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        lines.add(line);
        return line;
    }

    /**
     * Tworzy dodatkową zaokrągloną linię wchodzącą w skład świateł.
     * @return zwraca zaokrągloną linię wchodzącą w skład świateł.
     */
    private CubicCurve createFogLine(){
        CubicCurve cc = new CubicCurve();
        cc.setStartX(35);
        cc.setStartY(-25);
        cc.setEndX(35);
        cc.setEndY(125);
        cc.setControlX1(75);
        cc.setControlY1(25);
        cc.setControlX2(-5);
        cc.setControlY2(75);
        cc.setStroke(Color.BLACK);
        cc.setFill(Color.BLACK);
        cc.setStrokeWidth(10);
        curves.add(cc);
        return cc;
    }

    /**
     * @return zwraca grupę reprezentującą kontrolkę.
     */
    @Override
    public Group getGroup() {
        return group;
    }
    /**
     * @param mode parametr typu boolean, wartość false wyłącza kontrolkę, wartość true włącza kontrolkę.
     */
    public void changeMode(boolean mode) {
        if(mode){
            turnOn();
        }
        else
            turnOff();
    }
}
