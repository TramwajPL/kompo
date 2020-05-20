package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class HighBeamLight implements IndicatorLight {

    private Group group = new Group();
    private List<Line> lines = new ArrayList<>();
    private List<CubicCurve> curves = new ArrayList<>();

    HighBeamLight(){
        group.getChildren().add(getHeadlight());
        group.getChildren().add(getLines());
    }

    @Override
    public Group getHeadlight() {
        Group group = new Group();
        CubicCurve cc1 = new CubicCurve();
        cc1.setStartX(70);
        cc1.setStartY(0);
        cc1.setEndX(70);
        cc1.setEndY(100);
        cc1.setControlX1(200);
        cc1.setControlY1(0);
        cc1.setControlX2(200);
        cc1.setControlY2(100);
        cc1.setStroke(Color.BLACK);
        cc1.setFill(Color.BLACK);
        cc1.setStrokeWidth(10);

        CubicCurve cc2 = new CubicCurve();
        cc2.setStartX(70);
        cc2.setStartY(0);
        cc2.setEndX(70);
        cc2.setEndY(100);
        cc2.setControlX1(50);
        cc2.setControlY1(30);
        cc2.setControlX2(50);
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
        for(int i=0; i<101; i+=25 )
            group.getChildren().add(createLine(0,i,80,i));
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

    public void turnOn(){
        for(Line line: lines){
            line.setStroke(Color.BLUE);
        }
        for(CubicCurve cc: curves){
            cc.setStroke(Color.BLUE);
        }
    }

    public void turnOff(){
        for(Line line: lines){
            line.setStroke(Color.BLACK);
        }
        for(CubicCurve cc: curves){
            cc.setStroke(Color.BLACK);
        }
    }

}
