package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class SideLight implements Light {

    private Group group = new Group();
    private List<Line> lines = new ArrayList<>();
    private List<CubicCurve> curves = new ArrayList<>();

    @Override
    public void turnOff() {
        for(Line line: lines){
            line.setStroke(Color.BLACK);
        }
        for(CubicCurve cc: curves){
            cc.setStroke(Color.BLACK);
        }
    }

    @Override
    public void turnOn() {
        for(Line line: lines){
            line.setStroke(Color.GREEN);
        }
        for(CubicCurve cc: curves){
            cc.setStroke(Color.GREEN);
        }
    }

    SideLight(){
        group.getChildren().add(getHeadlight());
        group.getChildren().add(getLines());
        group.setLayoutX(500);

        Group group2 = new Group();
        group2.getChildren().add(getHeadlight());
        group2.getChildren().add(getLines());
        group2.setLayoutX(150);
        group2.setRotate(180);

        group.getChildren().add(group2);
    }

    @Override
    public Group getHeadlight() {
        Group group = new Group();
        CubicCurve cc1 = new CubicCurve();
        cc1.setStartX(70);
        cc1.setStartY(0);
        cc1.setEndX(70);
        cc1.setEndY(100);
        cc1.setControlX1(120);
        cc1.setControlY1(0);
        cc1.setControlX2(120);
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

    @Override
    public Group getLines() {
        Group group = new Group();
        group.getChildren().add(createLine(20,0,85,25));
        group.getChildren().add(createLine(20,50,80,50));
        group.getChildren().add(createLine(20,100,85,75));
        return group;
    }

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

    @Override
    public Group getGroup() {
        return group;
    }

    public void changeMode(boolean mode) {
        if(mode){
            turnOn();
        }
        else
            turnOff();
    }
}
