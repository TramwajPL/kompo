package view;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public interface IndicatorLight {
    Group getHeadlight();
    Group getLines();
    Line createLine(int startX, int startY, int endX, int endY);
    Group getGroup();
    void turnOff();
    void turnOn();
}
