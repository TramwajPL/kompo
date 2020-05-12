package view;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class RightIndicatorLight {

    private Polygon polygon = new Polygon();
    private Line line = new Line();
    private Group group = new Group();

    RightIndicatorLight()  {
        createPolygon();
        createLine();
        group.getChildren().add(polygon);
        group.getChildren().add(line);

    }

    private void createPolygon(){
        Double[] points = {800.0, 50.0, 700.0, 20.0, 700.0, 80.0};
        polygon.getPoints().addAll(points);
        polygon.setStroke(Color.ORANGE);
        polygon.setFill(Color.ORANGE);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), group);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
    }

    private void createLine(){
        line.setStartX(600);
        line.setStartY(50);
        line.setEndX(700);
        line.setEndY(50);
        line.setStrokeWidth(10);
        line.setStroke(Color.ORANGE);
    }

    public Group getGroup(){
        return group;
    }
}
