package view;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import logic.Travel;

public class SpeedViewer {

    private Label lab = new Label("0");
    private Travel travel;
    private Line index = new Line();


    SpeedViewer(Travel t) {
        travel = t;
        createLabel();
        createIndex();
        Group g = new Group();
        g.getChildren().add(index);
    }

    private void createIndex() {
        index.setStartX(-87);
        index.setStartY(-79);
        index.setEndX(-2);
        index.setEndY(0);
        index.setStroke(Color.RED);
        index.setStrokeWidth(12);
    }

    private void createLabel() {
        lab.setFont(new Font("Arial", 100));
        lab.setMaxWidth(Double.MAX_VALUE);
        lab.setAlignment(Pos.BOTTOM_CENTER);
        lab.setTextFill(Color.WHITE);
    }

    private void createArc(){
        Arc arc = new Arc();
    }


    public void labelUpdate(){
        lab.setText(travel.getSpeedAsString());
    }

    public void needleUpdate(){
        Integer diff = Integer.parseInt(travel.getSpeedAsString());

    }

    public Label getLabel(){
        return lab;
    }

    public Line getPointerNeedle(){
        return index;
    }

}
